package com.scorewell.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scorewell.db.MongoDBManager;

@Service
public class ScorewellService {

	private static Logger logger = LoggerFactory.getLogger(ScorewellService.class);
	
	@Autowired private DaoService daoService;
	
	
	
}
