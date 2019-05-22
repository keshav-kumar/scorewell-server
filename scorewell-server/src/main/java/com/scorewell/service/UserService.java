package com.scorewell.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.scorewell.config.UserConfig;
import com.scorewell.dto.User;
import com.scorewell.dto.UserRole;
import com.scorewell.dto.UserSession;
import com.scorewell.utils.AppUtils;
//import com.phcmga.server.ws.utils.AppUtils;
//import com.phcmga.server.ws.utils.EmailUtils;
import com.scorewell.utils.JsonUtils;
import com.scorewell.utils.StringUtils;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	private ExecutorService threadPool = Executors.newSingleThreadExecutor();
	
	@Autowired
	private DaoService daoService;
	
	@Autowired
	private UserConfig userConfig;
	
	public boolean isUserAllowed(String userId, String action) {
		// TODO Auto-generated method stub
		return true;
	}

	public JsonObject createUser(User user, String userRoleId) {
		user.setId(null);
		user.setDeleted(false);
		user.setCreateTime(System.currentTimeMillis());
		UserRole role = daoService.getUserRole(userRoleId);
		user.setRole(role);
		user.setPassword(StringUtils.getMD5Hash(user.getPassword()));
		User un=daoService.getUserByUsername(user.getUsername());
		if(un!=null){
			return JsonUtils.createErrorResponse("username already exist");
		}
		User ue=daoService.getUserByEmail(user.getEmail());
		if(ue!=null){
			return JsonUtils.createErrorResponse("email already exist");
		}
		String userId = daoService.createUser(user);
		return JsonUtils.createSuccessResponse(userId);
	}

	public User getUserDetail(String userId) {
		User user = daoService.getUser(userId);
		return user;
	}

	public List<User> listUsers(int n, int pos,String q,String sort) {
		List<User> users = daoService.listUsers(n, pos,q,sort);
		return users;
	}

	public JsonObject updateUserInfo(String userId, User user) {
		if(user==null){
			return JsonUtils.createErrorResponse("user is null");
		}
		User userFromDB = daoService.getUser(userId);
		if(userFromDB==null){
			return JsonUtils.createErrorResponse("user not found "+userId);
		}
		User un=daoService.getUserByUsername(user.getUsername());
		if(un!=null){
			if(!userId.equalsIgnoreCase(un.getId())){
				return JsonUtils.createErrorResponse("username already exist");
			}
		}
		User ue=daoService.getUserByEmail(user.getEmail());
		if(ue!=null){
			if(!userId.equalsIgnoreCase(ue.getId())){
				return JsonUtils.createErrorResponse("email already exist");
			}
		}
		AppUtils.merge(userFromDB,user);
		daoService.updateUser(userId,userFromDB);
		return JsonUtils.createSuccessResponse("updated");
	}

	public JsonObject updateUserPassword(String userId, String pass) {
		if(StringUtils.isEmpty(pass)){
			return JsonUtils.createErrorResponse("password is null");
		}
		String passwordHash = StringUtils.getMD5Hash(pass);
		daoService.updateUserPassword(userId,passwordHash);
		return JsonUtils.createSuccessResponse("updated");
	}

	public JsonObject updateUserStatus(String userId, boolean status) {
		daoService.updateUserStatus(userId,status);
		return JsonUtils.createSuccessResponse("updated");
	}
	
	public JsonObject updateUserMenu(String userId, boolean menu) {
		daoService.updateUserMenu(userId,menu);
		return JsonUtils.createSuccessResponse("updated");
	}

	public JsonObject createUserRole(UserRole userRole) {
		userRole.setId(null);
		userRole.setCreateTime(System.currentTimeMillis());
		UserRole ur = daoService.getUserRoleByName(userRole.getName());
		if(ur!=null){
			return JsonUtils.createErrorResponse("role already exist");
		}
		String roleId = daoService.createUserRole(userRole);
		return JsonUtils.createSuccessResponse(roleId);
	}

	public UserRole getUserRoleDetail(String roleId) {
		UserRole role = daoService.getUserRole(roleId);
		return role;
	}

	public JsonObject deleteUserRole(String roleId) {
		int rc=daoService.getTotalUserCountByRole(roleId);
		if(rc>0){
			return JsonUtils.createErrorResponse("assigned role can not delete");
		}
		daoService.deleteUserRole(roleId);
		return JsonUtils.createSuccessResponse("deleted "+roleId);
	}

	public List<UserRole> listUserRoles(int n, int pos,String q,String sort) {
		List<UserRole> roles = daoService.listUserRoles(n, pos,q,sort);
		return roles;
	}

	public JsonObject updateUserRoleInfo(String roleId, UserRole userRole) {
		if(userRole==null){
			return JsonUtils.createErrorResponse("userRole is null");
		}
		UserRole roleFromDB = daoService.getUserRole(roleId);
		if(roleFromDB==null){
			return JsonUtils.createErrorResponse("role not found "+roleId);
		}
		UserRole ur = daoService.getUserRoleByName(userRole.getName());
		if(ur!=null){
			if(!roleId.equalsIgnoreCase(userRole.getId())){
				return JsonUtils.createErrorResponse("role already exist");
			}
		}
		AppUtils.merge(roleFromDB,userRole);
		daoService.updateUserRole(roleId,roleFromDB);
		return JsonUtils.createSuccessResponse("updated");
	}

	public int getTotalUserRoleCount(String q) {
		return daoService.getTotalUserRoleCount(q);
	}

	public int getTotalUserCount(String q) {
		return daoService.getTotalUserCount(q);
	}

	public JsonObject loginByUserName(String user, String pass) {
		//String passwordHash = StringUtils.getMD5Hash(pass);
		String passwordHash = pass;
		try{
			User u = daoService.getUserByName(user,passwordHash);
			if(u==null){
				return JsonUtils.createErrorResponse("invalid user/pass");
			}
			daoService.fillDBObject(u.getRole(), UserRole.class);
			UserSession userSession = createSession(u);
			return JsonUtils.createSuccessResponse(userSession.getToken());
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return JsonUtils.createErrorResponse("invalid user/pass");
	}

	private UserSession createSession(User user) {
		long n  = System.nanoTime()*System.nanoTime();
		if(n<=0)n=-n;
		int k = (int) (user.getId().hashCode()*Math.random());
		if(k<0)k=-k;
		String token = n +""+k;
		UserSession session = new UserSession();
		session.setCreateTime(System.currentTimeMillis());
		session.setEmail(user.getEmail());
		session.setToken(token);
		session.setUserId(user.getId());
		daoService.createSession(session);
		return session;
	}
	
	public JsonObject loginByUserEmail(String email, String pass) {
		//String passwordHash = StringUtils.getMD5Hash(pass);
		String passwordHash = pass;
		try{
			User u = daoService.getUserByEmail(email,passwordHash);
			if(u==null){
				return JsonUtils.createErrorResponse("invalid user/pass");
			}
			UserSession userSession = createSession(u);
			return JsonUtils.createSuccessResponse(userSession.getToken());
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return JsonUtils.createErrorResponse("invalid user/pass");
	}

	public JsonObject logout(String token) {
		daoService.expireToken(token);
		return JsonUtils.createSuccessResponse("successful logout");
	}

	public boolean validate(String token) {
		UserSession session = daoService.getUserSessionByToken(token);
		return session!=null && !session.isExpired();
	}

	public User getUserDetailByToken(String token) {
		UserSession session = daoService.getUserSessionByToken(token);
		if(session!=null && !session.isExpired()){
			String userId = session.getUserId();
			User user = daoService.getUser(userId);
			User nuser = new User();
			nuser.setId(user.getId());
			nuser.setFirstname(user.getFirstname());
			nuser.setLastname(user.getLastname());
			nuser.setTitle(user.getTitle());
			nuser.setEmail(user.getEmail());
			nuser.setRole(user.getRole());
			daoService.fillDBObject(nuser.getRole(), UserRole.class);
			nuser.setPermissions(user.getPermissions());
			nuser.setMenuMinimized(user.isMenuMinimized());
			return nuser;
		}
		return null;
	}

	public JsonObject forgotPassword(String email) {
		User user = daoService.getUserByEmail(email);
		if(user==null){
			return JsonUtils.createErrorResponse("no such user");
		}
		threadPool.submit(() ->{
			UserSession session = createSession(user);
			String url = userConfig.getForgotPasswordUrl();
			url += "?token="+session.getToken();
			sendForgotpasswordEmail(email,url,user.getUsername());
		});
		return JsonUtils.createSuccessResponse("email sent");
	}

	private void sendForgotpasswordEmail(String email, String forgotPasswordLink, String usernName) {
		String body = "";
		body += "Hi "+(usernName!=null?usernName:"");
		body += "<br/>";
		body += "<br/>";
		body += "<br/>";
		body += "You can reset your password here:";
		body += "<br/>";
		body+= forgotPasswordLink;
		body += "<br/>";
		body += "<br/>";
		body += "<br/>";
		body += "If forgotpassword request is not requested by you, you can ignore this mail.";
		body += "<br/>";
//		EmailUtils.sendMail("Reset password for ProHealthCareMGA", body, "test.qa.gunaatita@gmail.com", Collections.singletonList(email), null, null, "test.qa.gunaatita@gmail.com", "16_Oct_2017");
	}
	
	public JsonObject createSubscribeOnlyUser(String email) {
		User user = new User();
		user.setEmail(email);
		user.setSubscribe_only(true);
		user.setId(null);
		user.setDeleted(false);
		user.setCreateTime(System.currentTimeMillis());
		UserRole role = daoService.getUserRole(null);
		user.setRole(role);
		user.setPassword(null);
		User ue=daoService.getUserByEmail(user.getEmail());
		if(ue!=null){
			return JsonUtils.createErrorResponse("email already exist");
		}
		String userId = daoService.createUser(user);
		return JsonUtils.createSuccessResponse(userId);
	}
	
	public List<String> getAllSubscribers() {
		return daoService.getAllSubscribers();
	}
	
//	public static void main(String []areg) {
//		
//		JsonObject resultSuc =  JsonUtils.createSuccessResponse("email already exist");
//		JsonObject resultFail =  JsonUtils.createErrorResponse("ds5675sdfds75sdfs");
//		
//		System.out.println(resultSuc.get("success"));
//		System.out.println(resultFail.get("success"));
//		
//		if(resultSuc.get("success").getAsBoolean()) {
//			System.out.println("hurrrrrr");
//		}
//		
//		if(!resultFail.get("success").getAsBoolean()) {
//			System.out.println("hurrrrrr");
//		}else {
//			System.out.println("hiiiiiiurrrrrr");
//		}
//			
//		
//	}

}
