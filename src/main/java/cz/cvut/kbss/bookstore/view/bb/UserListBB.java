/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.bookstore.view.bb;

import cz.cvut.kbss.bookstore.dto.UserDto;
import cz.cvut.kbss.bookstore.service.UserService;
import cz.cvut.kbss.bookstore.view.helper.FacesUtil;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mickapa1
 */
@Component("userListBB")
public class UserListBB implements Serializable{
    @Autowired
    private UserService userService;
    
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
    
    public void deleteUser(Long id){
        userService.deleteUser(id);
        FacesUtil.addMessage("User was sucessfully deleted");
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    
}
