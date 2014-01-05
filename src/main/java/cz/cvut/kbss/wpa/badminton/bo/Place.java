/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author zdeněk
 */
@Entity
public class Place extends AbstractBusinessObject {
    
    @ManyToMany
    @JoinTable(name="posible_places")
    private List<League> leagues;
    
    @OneToMany(mappedBy = "place")
    private List<Proposal> proposals;
    
    private String name;
    
    protected String adress;

    /**
     * @return the leagues
     */
    public List<League> getLeagues() {
        return leagues;
    }

    /**
     * @param leagues the leagues to set
     */
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    /**
     * @return the proposals
     */
    public List<Proposal> getProposals() {
        return proposals;
    }

    /**
     * @param proposals the proposals to set
     */
    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    
}
