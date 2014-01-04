/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.bo.User;
import cz.cvut.kbss.wpa.badminton.dto.UserDto;
import cz.cvut.kbss.wpa.badminton.helper.DtoTransformerHelper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author mickapa1
 */
@Component
public class UserServiceImpl extends AbstractDataAccessService implements UserService{
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = genericDao.getAll(User.class);
        List<UserDto> userDtos = new ArrayList<UserDto>();

        for (User u : users) {
            userDtos.add(new UserDto(u.getId(), u.getUserName(), u.getAge(), u.isAdmin(),DtoTransformerHelper.getIdentifiers(u.getBooks())));
        }
        return userDtos;
    }

    @Override
    public Long addUser(String userName, String password, int age, boolean isAdmin) {
        User newUser = new User();
        newUser.setAge(age);
        newUser.setPassword(password);
        newUser.setUserName(userName);
        newUser.setIsAdmin(isAdmin);

        return genericDao.saveOrUpdate(newUser).getId();
    }

    @Override
    public void deleteUser(Long userId) {
        genericDao.removeById(userId, User.class);
    }

    @Override
    public UserDto getUserById(Long id) {
        User u = genericDao.getByPropertyUnique("id", id, User.class);
        return new UserDto(u.getId(), u.getUserName(), u.getAge(), u.isAdmin(),DtoTransformerHelper.getIdentifiers(u.getBooks()));
    }
}
