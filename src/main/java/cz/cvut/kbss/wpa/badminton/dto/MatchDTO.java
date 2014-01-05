package cz.cvut.kbss.wpa.badminton.dto;

import java.util.List;

/**
 *
 * @author zdeněk
 */
public class MatchDTO extends AbstractDto{
    
    protected List<NoteDTO> notes;
    protected LeagueDTO league;
    protected List<ProposalDTO> proposals;

    public MatchDTO(Long id, List<NoteDTO> notes, LeagueDTO league, List<ProposalDTO> proposals) {
        this.id = id;
        this.notes = notes;
        this.league = league;
        this.proposals = proposals;
    }    

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }

    public LeagueDTO getLeague() {
        return league;
    }

    public void setLeague(LeagueDTO league) {
        this.league = league;
    }

    public List<ProposalDTO> getProposals() {
        return proposals;
    }

    public void setProposals(List<ProposalDTO> proposals) {
        this.proposals = proposals;
    }
    
    
}
