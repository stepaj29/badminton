/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.view.bb;

import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import cz.cvut.kbss.wpa.badminton.dto.UserDTO;
import cz.cvut.kbss.wpa.badminton.service.UserService;
import cz.cvut.kbss.wpa.badminton.view.helper.FacesUtil;
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
    
    public List<PlayerDTO> getAllUsers(){
        return userService.getAllPlayers();
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
