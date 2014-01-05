/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.view.bb;

import cz.cvut.kbss.wpa.badminton.service.UserService;
import cz.cvut.kbss.wpa.badminton.view.helper.FacesUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This bean is used in the register.xhtml gather form parameter values. 
 * Example of a request scope bean.
 * @author user
 */
@Component
@Scope(value="request")
public class RegisterBB {
    
    protected String userName;
    protected String password;
    protected String name;
    protected String surname;
    protected int weigth;
    protected int height;
    protected Date dateOfBirth;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    protected UserService userService;
    
    public void storePlayer(){
        userService.addPlayer(
                getUserName(),
                getPassword(),
                getName(),
                getSurname(),
                getWeigth(),
                getHeight(),
                getDateOfBirth()
        );
        FacesUtil.addMessage("User was sucessfully registered");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
