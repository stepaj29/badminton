/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.view.bb;

import cz.cvut.kbss.wpa.badminton.service.UserService;
import cz.cvut.kbss.wpa.badminton.view.helper.FacesUtil;
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
    
    protected String name;
    protected int age;
    protected String password;
    private boolean isAdmin;
    
    @Autowired
    protected UserService userService;
    
    public void storeUser(){
        userService.addUser(getName(), getPassword(), getAge(), isAdmin);
        FacesUtil.addMessage("User was sucessfully registered");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isAdmin
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
