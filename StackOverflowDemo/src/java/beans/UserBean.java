/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Users;

import user.service.UserService;

import userservice.Interfaces.IUserService;

/**
 *
 * @author Mahmoud Ragab
 */
@ManagedBean
@SessionScoped
public class UserBean {
    private int id;
    private String email;
    private String psw;
    private String name;
    IUserService userService;
    public UserBean() {
    }
    
    
    public String addUser(){
        try{
            Users user=new Users();
            user.setEmail(email);
            user.setPsw(psw);
            user.setName(name);
            getUserService().addUser(user);
            
        }catch(Exception ex){
            
        }
        return "Show-All";
    }
    
    
    
    public String login(){
        Users user =getUserService().getUserByEmail(email);
        
        if(user!=null&&user.getEmail().equals(email) && user.getPsw().equals(psw)){
            setName(user.getName());
            setId(user.getId());
            return "Show-All";
        }else
        return "Login";
        
    }
  
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
      public IUserService getUserService() {
		if(userService==null){
                    userService=new UserService();
                }
                return userService;
	}
    
            
    
    
}
