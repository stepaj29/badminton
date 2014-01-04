/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.bookstore.service;

import cz.cvut.kbss.wpa.badminton.service.UserService;
import cz.cvut.kbss.wpa.badminton.dto.UserDto;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mickapa1
 */
public class UserServiceImplTest extends AbstractServiceTest{
    @Autowired
    private UserService userService;
    
    @Test
    public void testAddAndRetrieveUser() {
        
        String userName = "UserName";
        String passwd = "passwd";
        int age = 18;
        
        Long id = userService.addUser(userName, passwd, age, true);
        UserDto userDto = userService.getUserById(id);
        
        assertEquals(userName, userDto.getUserName());
        assertEquals(age, userDto.getAge());
        
    }
    @Test
    public void testAddAndRemoveUser() {
        int size = userService.getAllUsers().size();
        String userName = "UserName";
        String passwd = "passwd";
        int age = 18;
        
        Long id = userService.addUser(userName, passwd, age, true);
        assertEquals(size + 1, userService.getAllUsers().size());
        userService.deleteUser(id);
        assertEquals(size, userService.getAllUsers().size());        
    }      

}
