package com.scorewell.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import com.scorewell.dto.BaseDBObject;
import com.scorewell.dto.Question;
import com.scorewell.dto.QuestionSet;
import com.scorewell.utils.AppUtils;
import com.scorewell.utils.MongoUtils;
import com.scorewell.db.MongoDBManager;
import com.scorewell.dto.User;
import com.scorewell.dto.UserActivity;
import com.scorewell.dto.UserRole;
import com.scorewell.dto.UserSession;
import com.scorewell.utils.StringUtils;


@Service
public class DaoService {

	private static String USER_INFO_COLLECTION = "user_info";
	private static String USER_ROLE_INFO_COLLECTION = "user_role_info";
	private static String USER_SESSION_COLLECTION = "user_session";
	private static String QUESTION_SET = "question_set";
	private static String USER_ACTIVITY = "user_activity";
	

	@Autowired
	private MongoDBManager mongoDBManager;
	
	private <T> T getDocToClass(Document doc, Class<T> klass) {
		Object idObj = doc.remove("_id");
		BasicDBObject dbObj = (BasicDBObject) JSON.parse(doc.toJson());
		Gson gson = new Gson();
		T t = gson.fromJson(dbObj.toString(), klass);
		if (idObj != null) {
			String id = idObj.toString();
			try {
				Method[] methods = t.getClass().getMethods();
				for (Method m : methods) {
					if (m.getName().contains("setId")) {
						m.invoke(t, id);
					}
				}
			} catch (Exception e) {
			}
		}
		return t;
	}
	
	private <T> String getCollectionForClass(Class<T> klass) {
		if (klass == UserRole.class) {
			return USER_ROLE_INFO_COLLECTION;
		}
		return null;
	}

	public UserRole getUserRole(String userRoleId) {
		if (StringUtils.isEmpty(userRoleId)) {
			return null;
		}
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("_id", new ObjectId(userRoleId));
		Document document = mongoDBManager.getObject(USER_ROLE_INFO_COLLECTION, queryParams);
		if (document != null) {
			UserRole userRole = getDocToClass(document, UserRole.class);
			return userRole;
		}
		return null;
	}

	public UserRole getUserRoleByName(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("name", name);
		Document document = mongoDBManager.getObject(USER_ROLE_INFO_COLLECTION, queryParams);
		if (document != null) {
			UserRole userRole = getDocToClass(document, UserRole.class);
			return userRole;
		}
		return null;
	}

	public String createUser(User user) {
		String userId = mongoDBManager.addObject(USER_INFO_COLLECTION, new Gson().toJson(user));
		return userId;
	}

	public User getUser(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return null;
		}
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("_id", new ObjectId(userId));
		Document document = mongoDBManager.getObject(USER_INFO_COLLECTION, queryParams);
		if (document != null) {
			User user = getDocToClass(document, User.class);
			return user;
		}
		return null;
	}

	public List<User> listUsers(int n, int pos, String q, String sort) {
		Map<String, Object> queryParams = new HashMap<>();
		if (!StringUtils.isEmpty(q)) {
			List<Map<String, Object>> orList = new ArrayList<>();
			orList.add(Collections.singletonMap("title", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			orList.add(Collections.singletonMap("firstname", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			orList.add(Collections.singletonMap("lastname", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			queryParams.put("$or", orList);
		}
		Map<String, Object> sortMap = null;
		if (!StringUtils.isEmpty(sort)) {
			if (sort.contains("role")) {
				sort = sort.replace("role", "role.name");
			}
			sortMap = MongoUtils.getSortMap(sort);
		}
		queryParams.put("deleted", false);
		List<Document> documents = mongoDBManager.getObjects(USER_INFO_COLLECTION, pos, n, queryParams, sortMap);
		if (documents != null) {
			List<User> list = documents.stream().map(o -> getDocToClass(o, User.class)).collect(Collectors.toList());
			return list;
		}
		return null;
	}

	public void updateUser(String id, User userFromDB) {
		JsonObject jsonObj = new Gson().toJsonTree(userFromDB).getAsJsonObject();
		jsonObj.remove("id");
		mongoDBManager.addObject(USER_INFO_COLLECTION, id, jsonObj.toString());
	}

	public void updateUserPassword(String userId, String passwordHash) {
		Map<String, Object> query = new HashMap<>();
		query.put("_id", new ObjectId(userId));
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("password", passwordHash);
		mongoDBManager.setField(USER_INFO_COLLECTION, query, fieldMap);
	}

	public void updateUserStatus(String userId, boolean status) {
		Map<String, Object> query = new HashMap<>();
		query.put("_id", new ObjectId(userId));
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("active", status);
		mongoDBManager.setField(USER_INFO_COLLECTION, query, fieldMap);
	}

	public void updateUserMenu(String userId, boolean menu) {
		Map<String, Object> query = new HashMap<>();
		query.put("_id", new ObjectId(userId));
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("menuMinimized", menu);
		mongoDBManager.setField(USER_INFO_COLLECTION, query, fieldMap);
	}

	public String createUserRole(UserRole userRole) {
		String roleId = mongoDBManager.addObject(USER_ROLE_INFO_COLLECTION, new Gson().toJson(userRole));
		return roleId;
	}

	public void deleteUserRole(String roleId) {
		Map<String, Object> query = new HashMap<>();
		query.put("_id", new ObjectId(roleId));
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("deleted", true);
		mongoDBManager.setField(USER_ROLE_INFO_COLLECTION, query, fieldMap);
	}

	public List<UserRole> listUserRoles(int n, int pos, String q, String sort) {
		Map<String, Object> queryParams = new HashMap<>();
		if (!StringUtils.isEmpty(q)) {
			queryParams.put("name", Pattern.compile(q, Pattern.CASE_INSENSITIVE));
		}
		Map<String, Object> sortMap = null;
		if (!StringUtils.isEmpty(sort)) {
			sortMap = MongoUtils.getSortMap(sort);
		}
		queryParams.put("deleted", false);
		List<Document> documents = mongoDBManager.getObjects(USER_ROLE_INFO_COLLECTION, pos, n, queryParams, sortMap);
		if (documents != null) {
			List<UserRole> list = documents.stream().map(o -> getDocToClass(o, UserRole.class))
					.collect(Collectors.toList());
			return list;
		}
		return null;
	}

	public void updateUserRole(String id, UserRole roleFromDB) {
		JsonObject jsonObj = new Gson().toJsonTree(roleFromDB).getAsJsonObject();
		jsonObj.remove("id");
		mongoDBManager.addObject(USER_ROLE_INFO_COLLECTION, id, jsonObj.toString());
	}

	public int getTotalUserRoleCount(String q) {
		Map<String, Object> queryParams = new HashMap<>();
		if (!StringUtils.isEmpty(q)) {
			List<Map<String, Object>> orList = new ArrayList<>();
			orList.add(Collections.singletonMap("name", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			queryParams.put("$or", orList);
		}
		queryParams.put("deleted", false);
		long count = mongoDBManager.getCount(USER_ROLE_INFO_COLLECTION, queryParams);
		return (int) count;
	}

	public int getTotalUserCount(String q) {
		Map<String, Object> queryParams = new HashMap<>();
		if (!StringUtils.isEmpty(q)) {
			List<Map<String, Object>> orList = new ArrayList<>();
			orList.add(Collections.singletonMap("title", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			orList.add(Collections.singletonMap("firstname", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			orList.add(Collections.singletonMap("lastname", Pattern.compile(q, Pattern.CASE_INSENSITIVE)));
			queryParams.put("$or", orList);
		}
		queryParams.put("deleted", false);
		long count = mongoDBManager.getCount(USER_INFO_COLLECTION, queryParams);
		return (int) count;
	}

	public int getTotalUserCountByRole(String roleId) {
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("role.id", roleId);
		long count = mongoDBManager.getCount(USER_INFO_COLLECTION, queryParams);
		return (int) count;
	}

	public UserSession getUserSessionByToken(String token) {
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("token", token);
		Document document = mongoDBManager.getObject(USER_SESSION_COLLECTION, queryParams);
		if (document != null) {
			UserSession userSession = getDocToClass(document, UserSession.class);
			return userSession;
		}
		return null;
	}

	public void expireToken(String token) {
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("token", token);
		Map<String, Object> fieldValueMap = new HashMap<>();
		fieldValueMap.put("expired", true);
		mongoDBManager.setField(USER_SESSION_COLLECTION, queryParams, fieldValueMap, false, true);
	}

	public void createSession(UserSession session) {
		mongoDBManager.addObject(USER_SESSION_COLLECTION, new Gson().toJson(session));
	}

	public User getUserByName(String user, String passwordHash) {
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("active", true);
		queryParams.put("username", user);
		queryParams.put("password", passwordHash);
		Document document = mongoDBManager.getObject(USER_INFO_COLLECTION, queryParams);
		if (document != null) {
			User u = getDocToClass(document, User.class);
			return u;
		}
		return null;
	}

	public User getUserByEmail(String email, String passwordHash) {
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("active", true);
		queryParams.put("email", email);
		queryParams.put("password", passwordHash);
		Document document = mongoDBManager.getObject(USER_INFO_COLLECTION, queryParams);
		if (document != null) {
			User u = getDocToClass(document, User.class);
			return u;
		}
		return null;
	}

	public User getUserByEmail(String email) {
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("email", email);
		Document document = mongoDBManager.getObject(USER_INFO_COLLECTION, queryParams);
		if (document != null) {
			User u = getDocToClass(document, User.class);
			return u;
		}
		return null;
	}

	public User getUserByUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return null;
		}
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("deleted", false);
		queryParams.put("username", username);
		Document document = mongoDBManager.getObject(USER_INFO_COLLECTION, queryParams);
		if (document != null) {
			User user = getDocToClass(document, User.class);
			return user;
		}
		return null;
	}

	public <T extends BaseDBObject> void fillDBObject(T dest, Class<T> klass) {
		if (dest == null || dest.getId() == null) {
			return;
		}
		String collectionName = getCollectionForClass(klass);
		if (collectionName == null) {
			return;
		}
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("_id", new ObjectId(dest.getId()));
		Document document = mongoDBManager.getObject(collectionName, queryParams);
		if (document != null) {
			T src = getDocToClass(document, klass);
			AppUtils.copyObject(src, dest);
		}
	}
	
	
	public String createSubscriber(User user) {
		String userId = mongoDBManager.addObject(USER_INFO_COLLECTION, new Gson().toJson(user));
		return userId;
	}
	
	public List<String> getAllSubscribers(){
		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("subscribe_only", true);
		
		List<Document> objects = mongoDBManager.getObjects(USER_INFO_COLLECTION, queryParam);
		List<String> emails = new ArrayList<>();
		if(objects!=null){
			for(org.bson.Document d:objects) {
				String email = d.getString("email");
				emails.add(email);
			}
		}
		return emails;
	}

	public String createQuestionSet(QuestionSet questionSet) {
		String questionSetId = mongoDBManager.addObject(QUESTION_SET, new Gson().toJson(questionSet));
		return questionSetId;
	}
	
	public String saveUserActivity(UserActivity userActivity) {
		String userActivityId = mongoDBManager.addObject(USER_ACTIVITY, new Gson().toJson(userActivity));
		return userActivityId;
	}
	
	public void updateUserActivity(HttpServletRequest request) {
		
		Map<String, Object> query = new HashMap<>();
		query.put("userName", request.getParameter("name"));
		query.put("emailId", request.getParameter("email"));
		query.put("phone", request.getParameter("phone"));
		query.put("setName", request.getParameter("setName"));
		
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("evaluated", true);
		mongoDBManager.setField(USER_ACTIVITY, query, fieldMap);
		
	}
	
	public List<QuestionSet> getQuestionSet(String course) {

		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("course", course);
//		queryParam.put("subjectName", subjectName);
		queryParam.put("deleted", false);

		Map timeConstraint = new HashMap();
//		long today = StringUtils
//				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy"), "dd-MM-yyyy").getTime();
		
		long today = StringUtils
				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy HH:MM:SS"), "dd-MM-yyyy HH:MM:SS").getTime();
		
		timeConstraint.put("$lte", today);
		queryParam.put("releaseDate", timeConstraint);
		
		Map<String, Object> sortmap = new HashMap<>();
		sortmap.put("releaseDate", -1);
		
		List<Document> documents = mongoDBManager.getObjects(QUESTION_SET, 0, -1, queryParam, sortmap);
//		List<Document> documents = mongoDBManager.getObjects(QUESTION_SET, queryParam);
		System.out.println("Mongo Result : "+documents.size());
		if (documents != null) {
			List<QuestionSet> list = documents.stream().map(o -> getDocToClass(o, QuestionSet.class))
					.collect(Collectors.toList());
			return list;
		}
		
		return null;
	}
	
	public String getLatestQuestionSetName(String course, String subjectName) {
		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("course", course);
		queryParam.put("subjectName", subjectName);
		
		Map<String, Object> sortmap = new HashMap<>();
		sortmap.put("releaseDate", -1);
		List<Document> documents = mongoDBManager.getObjects(QUESTION_SET, 0, 1, queryParam, sortmap);
		
		System.out.println("Mongo Result : "+documents.size());
		
		if (documents.size()>0 && documents != null) {
			List<QuestionSet> queList = documents.stream().map(o -> getDocToClass(o, QuestionSet.class))
					.collect(Collectors.toList());
			return queList.get(0).getSetName();
		}
		return null;
	}
	
	public List<UserActivity> getUserActivity(HttpServletRequest request) {
		
		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("userName", request.getParameter("name"));
		queryParam.put("emailId", request.getParameter("email"));
		queryParam.put("phone", request.getParameter("phone"));
		
		Map<String, Object> sortmap = new HashMap<>();
		sortmap.put("uploadDateTime", -1);
		List<Document> documents = mongoDBManager.getObjects(USER_ACTIVITY, 0, -1, queryParam, sortmap);
		
		if (documents != null) {
			List<UserActivity> list = documents.stream().map(o -> getDocToClass(o, UserActivity.class))
					.collect(Collectors.toList());
			
			return list;
		}
		
		return null;
	}
	
	public List<UserActivity> getUserActivityAdmin(HttpServletRequest request) {
		
		Map<String, Object> queryParam = new HashMap<>();
		
		if(request.getParameter("name") != null && !request.getParameter("name").isEmpty())
			queryParam.put("userName", request.getParameter("name"));
		if(request.getParameter("email") != null && !request.getParameter("email").isEmpty())
			queryParam.put("emailId", request.getParameter("email"));
		if(request.getParameter("phone") != null && !request.getParameter("phone").isEmpty())
			queryParam.put("phone", request.getParameter("phone"));
		
		Map<String, Object> sortmap = new HashMap<>();
		sortmap.put("uploadDateTime", -1);
		List<Document> documents = mongoDBManager.getObjects(USER_ACTIVITY, 0, -1, queryParam, sortmap);
		
		if (documents != null) {
			List<UserActivity> list = documents.stream().map(o -> getDocToClass(o, UserActivity.class))
					.collect(Collectors.toList());
			
			return list;
		}
		
		return null;
	}
	
	public QuestionSet getQuestionSetByName(String setName) {

		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("setName", setName);
		queryParam.put("deleted", false);

		List<Document> documents = mongoDBManager.getObjects(QUESTION_SET, queryParam);
		if (documents != null) {
			List<QuestionSet> list = documents.stream().map(o -> getDocToClass(o, QuestionSet.class))
					.collect(Collectors.toList());
			return list.get(0);
		}
		
		return null;
	}
	
	public List<String> getUrlsFromWebpageData() {
		
		MongoDBManager mongoDBManager_1 = new MongoDBManager("localhost", "score_well");
		Map<String, Object> queryParams_1 = new HashMap<>();
//		queryParams_1.put("course", "IAS");
		queryParams_1.put("deleted", false);
		
		Map timeConstraint = new HashMap();
		long today = StringUtils
				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy"), "dd-MM-yyyy").getTime();
		timeConstraint.put("$lte", today);
		queryParams_1.put("releaseDate", timeConstraint);
		
		List<Document> objects_1 = mongoDBManager_1.getObjects("question_set", queryParams_1);
		List<QuestionSet> list = objects_1.stream().map(o -> getDocToClass(o, QuestionSet.class))
				.collect(Collectors.toList());
		if(list!=null) {
			for(QuestionSet d:list) {
				Question question = d.getQuestions().get(0);
				System.out.println(question);

			}
		}
		
		
		MongoDBManager mongoDBManager = new MongoDBManager("localhost", "jobmatcher");
		
		System.out.println("In Doa Service getUrl methods");
		Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("complete", true);
//		List<Document> objects = mongoDBManager.getObjects("webpage_data", queryParams);
//		System.out.println("Mongo Result : "+objects.size());
		List<String> urls = new ArrayList<>();
//		if(objects!=null) {
//			for(org.bson.Document d:objects) {
//				String url = d.getString("url");
//				System.out.println(url);
//				urls.add(url);
//			}
//		}
		return urls;
	}
	
	public void deleteQuestionSet(String setName) {
		Map<String, Object> query = new HashMap<>();
		query.put("setName", setName);
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("deleted", true);
		mongoDBManager.setField(QUESTION_SET, query, fieldMap);
	}
	
	public void updateTest(boolean status) {
		
		MongoDBManager mongoDBManager = new MongoDBManager("localhost", "score_well");
		
		Map<String, Object> query = new HashMap<>();
		query.put("userName", "kes");
		query.put("emailId", "keshav.softengg");
		query.put("phone", "12345");
		query.put("setName", "dhing chak");
		
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("evaluated", status);
		mongoDBManager.setField(USER_ACTIVITY, query, fieldMap);
		
	}
	
//	public static void main(String[] str) {
//		
//		DaoService daoService = new DaoService();
//		daoService.updateTest(false);
//	}
	
	
//	{
////		
//		System.out.println(list.size());
////		
////		for(UserActivity actv:list) {
////			System.out.println("Name : "+actv.getUserName()+"  "+actv.getPhone()+" "+actv.getEmailId());
////		}
////		
//////		long currentTime = StringUtils
//////				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy"), "dd-MM-yyyy").getTime();
//////		System.out.println(currentTime);
//////		
//////		System.out.println(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy"));
//////		
//////		DaoService daoService = new DaoService();
//////		List<QuestionSet> questionSets= daoService.getQuestionSet("IAS", "ga");
//////		
//////		List<String> urls = daoService.getUrlsFromWebpageData();
////
//////		List<String> urls = new ArrayList<>();
//////		if(urls!=null) {
//////			for(String d:urls) {
//////				
//////				System.out.println(d);
//////			}
//////		}
////		
//	}
	
}
