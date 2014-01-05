package cz.cvut.kbss.wpa.badminton.dto;

import java.util.Date;

/**
 *
 * @author jan
 */
public class EnrollDTO extends AbstractDto{
    protected PlayerDTO player;
    protected LeagueDTO league;
    protected Date paid;

    public EnrollDTO(Long id, PlayerDTO player, LeagueDTO league, Date paid) {
        this.id = id;
        this.player = player;
        this.league = league;
        this.paid = paid;
    }
    
    

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public LeagueDTO getLeague() {
        return league;
    }

    public void setLeague(LeagueDTO league) {
        this.league = league;
    }

    public Date getPaid() {
        return paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }
}
