package com.egen.egenSparkMongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UserDAO {
	
	 private final DB db;
	 private final DBCollection collection;
	 
	 public UserDAO(DB db){
		 this.db = db;
	     this.collection = db.getCollection("egenuser");
	 }
	 
	 public List<User> findAll() {
	        List<User> userList = new ArrayList<>();
	        DBCursor dbObjects = collection.find();
	        while (dbObjects.hasNext()) {
	            DBObject dbObject = dbObjects.next();
	            userList.add(new User((BasicDBObject) dbObject));
	        }
	        return userList;
	 }

	public String createUser(String body) {
		User user = new Gson().fromJson(body, User.class);
		if(user.getId()==null){
			collection.insert(new BasicDBObject("firstName", user.getFirstName())
			.append("lastName", user.getLastName())
			.append("email", user.getEmail())
			.append("dateCreated", new Date())
			.append("profilePic", user.getProfilePic())
			.append("address", new BasicDBObject("street", user.getStreet())
			                            .append("city", user.getCity())
			                            .append("zip",user.getZip())
			                            .append("state",user.getState())
			                            .append("country",user.getCountry()))
			.append("company", new BasicDBObject("cName", user.getcName())
			                            .append("cWebsite", user.getcWebsite()))
			);
			return "User Added Successfully";
		}
		else{
			return "User is not valid";
		}
		
	}
	
	public String update(String userId, String body) {
		User newUser = new Gson().fromJson(body, User.class);
		if(findUser(userId)!=null){
			 collection.update(new BasicDBObject("_id", new ObjectId(userId)), new BasicDBObject("$set", new BasicDBObject("firstName", newUser.getFirstName())));
			 return "User Updated Successfully";
		}
        return "User Does not Exist";
    }
	
	public User findUser(String userId) {
        return new User((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(userId))));
    }

}

