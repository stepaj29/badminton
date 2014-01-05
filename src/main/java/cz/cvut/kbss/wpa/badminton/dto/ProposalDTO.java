package cz.cvut.kbss.wpa.badminton.dto;

import java.util.Date;

/**
 *
 * @author jan
 */
public class ProposalDTO extends AbstractDto{
    
    protected PlaceDTO place;
    protected MatchDTO match;
    protected PlayerDTO player;
    protected Date propDate;

    public ProposalDTO(Long id, PlaceDTO place, MatchDTO match, PlayerDTO player, Date propDate) {
        this.id = id;
        this.place = place;
        this.match = match;
        this.player = player;
        this.propDate = propDate;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public MatchDTO getMatch() {
        return match;
    }

    public void setMatch(MatchDTO match) {
        this.match = match;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public Date getPropDate() {
        return propDate;
    }

    public void setPropDate(Date propDate) {
        this.propDate = propDate;
    }
    
}
