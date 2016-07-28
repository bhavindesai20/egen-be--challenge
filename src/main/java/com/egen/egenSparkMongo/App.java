package com.egen.egenSparkMongo;

import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class App 
{
	 public static void main(String[] args) throws Exception {
	        new UserController(new UserDAO(mongo()));
	    }
	 
	    private static DB mongo() throws UnknownHostException{
	            MongoClient mongoClient = new MongoClient("localhost",27017);
	            DB db = mongoClient.getDB("egen");
				return db;     
	    }
}
