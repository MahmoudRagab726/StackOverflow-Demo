/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userservice.Interfaces;

import model.Users;

/**
 *
 * @author Mahmoud Ragab
 */
public interface IUserService {
    public void addUser(Users user);
    
    public Users getUserByEmail(String email);
    
}
