/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.dto;

import java.util.List;

/**
 *
 * @author mickapa1
 */
public class UserDto extends AbstractDto{
    private String userName;
    private int age;
    private boolean isAdmin;
    private List<Long> books;

    public UserDto() {
    }
    
    

    public UserDto(Long id, String userName, int age, boolean isAdmin, List<Long> books) {
        this.id = id;
        this.age = age;
        this.userName = userName;
        this.books = books;
        this.isAdmin = isAdmin;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    
    
    
    public List<Long> getBooks() {
        return books;
    }

    public void setBooks(List<Long> books) {
        this.books = books;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
