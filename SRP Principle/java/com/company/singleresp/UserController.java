package com.company.singleresp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {

	private UserValidator userValidator = new UserValidator();
    private UserPersistenceService userPersistanceService = new UserPersistenceService();
    
    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        User user = mapper.readValue(userJson, User.class);

        if(!userValidator.isValidUser(user)) {
            return "ERROR";
        }
        
        userPersistanceService.saveUser(user);
        
        return "SUCCESS";
    } 


}