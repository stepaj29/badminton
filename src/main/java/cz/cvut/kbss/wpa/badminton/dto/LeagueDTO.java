/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author zdeněk
 */
public class LeagueDTO extends AbstractDto {
    
    protected List<MatchDTO> matches;
    protected List<EnrollDTO> enrolls;
    protected String name;
    protected Date leagueStart;
    protected Date leagueEnd;
    
    public LeagueDTO(Long id, List<MatchDTO> matches, List<EnrollDTO> enrolls, String name, Date leagueStart, Date leagueEnd)
    {
        this.id = id;
        this.enrolls = enrolls;
        this.matches = matches;
        this.name = name;
        this.leagueStart = leagueStart;
        this.leagueEnd = leagueEnd;
    }
    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }

    public List<EnrollDTO> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(List<EnrollDTO> enrolls) {
        this.enrolls = enrolls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLeagueStart() {
        return leagueStart;
    }

    public void setLeagueStart(Date leagueStart) {
        this.leagueStart = leagueStart;
    }

    public Date getLeagueEnd() {
        return leagueEnd;
    }

    public void setLeagueEnd(Date leagueEnd) {
        this.leagueEnd = leagueEnd;
    }
}
