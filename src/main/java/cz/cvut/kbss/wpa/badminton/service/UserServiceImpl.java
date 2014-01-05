/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.bo.Admin;
import cz.cvut.kbss.wpa.badminton.bo.Player;
import cz.cvut.kbss.wpa.badminton.bo.User;
import cz.cvut.kbss.wpa.badminton.dto.AdminDTO;
import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import cz.cvut.kbss.wpa.badminton.dto.UserDTO;
import cz.cvut.kbss.wpa.badminton.helper.DtoTransformerHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author mickapa1
 */
@Component
public class UserServiceImpl extends AbstractDataAccessService implements UserService{
    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = genericDao.getAll(Player.class);
        List<PlayerDTO> playerDTOs = new ArrayList<PlayerDTO>();

        for (Player u : players) {
            playerDTOs.add(
                    new PlayerDTO(
                            u.getId(),
                            u.getUserName(),
                            u.getName(),
                            u.getSurname(),
                            u.getWeigth(),
                            u.getHeight(),
                            u.getDateOfBirth(),
                            null,
                            null
                    )
            );
        }
        return playerDTOs;
    }

    @Override
    public Long addPlayer(
            String userName,
            String password,
            String name,
            String surname,
            int weigth,
            int height,
            Date dateOfBirth) {
        Player newPlayer = new Player();
        newPlayer.setPassword(password);
        newPlayer.setUserName(userName);
        newPlayer.setName(name);
        newPlayer.setSurname(surname);
        newPlayer.setDateOfBirth(dateOfBirth);
        newPlayer.setWeigth(weigth);
        newPlayer.setHeight(height);

        return genericDao.saveOrUpdate(newPlayer).getId();
    }

    @Override
    public Long addAdmin(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public void deleteUser(Long userId) {
        genericDao.removeById(userId, User.class);
    }

    @Override
    public UserDTO getPlayerById(Long id) {
        Player u = genericDao.getByPropertyUnique("id", id, Player.class);
        return new PlayerDTO(
                u.getId(),
                u.getUserName(),
                u.getName(),
                u.getSurname(),
                u.getWeigth(),
                u.getHeight(),
                u.getDateOfBirth(),
                null,
                null
        );
    }
}
