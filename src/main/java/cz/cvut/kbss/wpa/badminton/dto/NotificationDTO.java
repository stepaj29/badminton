/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.dto;

/**
 *
 * @author jan
 */
public class NotificationDTO extends AbstractDto{
    
    protected PlayerDTO player;
    protected String message;

    public NotificationDTO(Long id, PlayerDTO player, String message) {
        this.id = id;
        this.player = player;
        this.message = message;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
