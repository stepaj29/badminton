/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.UserDto;
import java.util.List;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mickapa1
 */
@Transactional
public interface UserService {

    /**
     * Add user to the system
     * @param userName username
     * @param password password as an open text (will be stored in hashed form)
     * @param age age of the user
     * @return identifier of the user stored
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Long addUser(String userName, String password, int age, boolean isAdmin);

    /**
     * Permanently removes the user
     * @param userId id of the user to be removed
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(Long userId);
    /**
     * Return user with the given id
     * @param id idenfier of the user to be retrieved
     * @return user with the given id, null if the user does not exist
     */
    @PreAuthorize(
            "hasRole('ROLE_ADMIN') or " +
            "hasRole('ROLE_USER')")
    @Transactional(readOnly=true)
    public UserDto getUserById(Long id);

    /**
     * Get all users stored in the system
     * @return 
     */
    @PreAuthorize(
            "hasRole('ROLE_ADMIN') or " +
            "hasRole('ROLE_USER')")    
    @Transactional(readOnly=true)
    public List<UserDto> getAllUsers();
}
