package cz.cvut.kbss.wpa.badminton.dto;

/**
 *
 * @author mickapa1
 */
public class UserDTO extends AbstractDto{
    private String userName;

    public UserDTO() {
    }
    
    

    public UserDTO(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    } 

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
