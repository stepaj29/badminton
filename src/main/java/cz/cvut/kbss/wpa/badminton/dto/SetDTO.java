package cz.cvut.kbss.wpa.badminton.dto;

/**
 *
 * @author zdeněk
 */
public class SetDTO extends AbstractDto {
    
    private int number;
    private int score;
    protected  NoteDTO note;

    public SetDTO(Long id, int number, int score, NoteDTO note) {
        this.id = id;
        this.number = number;
        this.score = score;
        this.note = note;
    }
    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public NoteDTO getNote() {
        return note;
    }

    public void setNote(NoteDTO note) {
        this.note = note;
    }
}
