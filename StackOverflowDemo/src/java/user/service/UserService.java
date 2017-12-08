/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.service;

import model.Users;
import user.dao.IUserDAO;
import user.dao.UserDao;
import userservice.Interfaces.IUserService;

/**
 *
 * @author Mahmoud Ragab
 */
public class UserService implements IUserService{
IUserDAO userDAO;
    @Override
    public void addUser(Users user) {
            getUserDAO().addUser(user);
            
    }
    
     @Override
    public Users getUserByEmail(String email) {
       return getUserDAO().getUserByEmail(email);
    }
    
    
    public IUserDAO getUserDAO() {
		if(userDAO==null){
                    userDAO=new UserDao();
                }
                return userDAO;
	}

   
    
}
