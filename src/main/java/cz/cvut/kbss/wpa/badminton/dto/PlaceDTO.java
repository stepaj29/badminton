package cz.cvut.kbss.wpa.badminton.dto;

import java.util.List;

/**
 *
 * @author jan
 */
public class PlaceDTO extends AbstractDto{
    
    protected List<LeagueDTO> leagues;
    protected List<ProposalDTO> proposals;
    protected String name;
    protected String adress;

    public PlaceDTO(Long id, List<LeagueDTO> leagues, List<ProposalDTO> proposals, String name, String adress) {
        this.id = id;
        this.leagues = leagues;
        this.proposals = proposals;
        this.name = name;
        this.adress = adress;
    }

    public List<LeagueDTO> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<LeagueDTO> leagues) {
        this.leagues = leagues;
    }

    public List<ProposalDTO> getProposals() {
        return proposals;
    }

    public void setProposals(List<ProposalDTO> proposals) {
        this.proposals = proposals;
    }

    public String getName() {
        return name;
    }

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
