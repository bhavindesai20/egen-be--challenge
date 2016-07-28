package com.egen.egenSparkMongo;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

public class UserController {
	 private static final String API_CONTEXT = "/api/v1";
	    private final UserDAO userDAO;
	    public UserController(UserDAO userdao) {
	        this.userDAO = userdao;
	        setupEndpoints();
	    }
	 
	    private void setupEndpoints() {
	        get(API_CONTEXT + "/getAllUsers", "application/json", (request, response)
	                -> userDAO.findAll(), new JsonTransformer());
	        
	        post(API_CONTEXT + "/createUser", "application/json", (request, response) -> {
	        	userDAO.createUser(request.body());
	            response.status(200);
	            return response;
	        }, new JsonTransformer());
	        
	        put(API_CONTEXT + "/user/:id", "application/json", (request, response)
	                -> userDAO.update(request.params(":id"), request.body()), new JsonTransformer());
	    }

}
