/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.bo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zdeněk
 */
@Entity
public class League extends AbstractBusinessObject {
    
    @OneToMany(mappedBy="league")
    private List<Match> matches;
    
    @ManyToMany
    @JoinTable(name="posible_places")
    private List<Place> places;
    
    @OneToMany(mappedBy = "league")
    private List<Enroll> enrolls;
    
    protected String name;
    
    @Temporal(TemporalType.DATE)
    protected Date leagueStart;
    
    @Temporal(TemporalType.DATE)
    protected Date leagueEnd;

    /**
     * @return the matches
     */
    public List<Match> getMatches() {
        return matches;
    }

    /**
     * @param matches the matches to set
     */
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    /**
     * @return the places
     */
    public List<Place> getPlaces() {
        return places;
    }

    /**
     * @param places the places to set
     */
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    /**
     * @return the enrolls
     */
    public List<Enroll> getEnrolls() {
        return enrolls;
    }

    /**
     * @param enrolls the enrolls to set
     */
    public void setEnrolls(List<Enroll> enrolls) {
        this.enrolls = enrolls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return leagueStart;
    }

    public void setStart(Date start) {
        this.leagueStart = start;
    }

    public Date getEnd() {
        return leagueEnd;
    }

    public void setEnd(Date end) {
        this.leagueEnd = end;
    }
    
    
}
