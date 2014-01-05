/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.bo;

import cz.cvut.kbss.wpa.badminton.provider.HashProvider;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author zdeněk
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorOptions(force=true)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type", length = 20)
@DiscriminatorValue(value = "user")
@Configurable(preConstruction=true)
public abstract class User extends AbstractBusinessObject {

    @Column(length = 40, nullable = false,unique = true)
    private String userName;

    @Column(length = 40, nullable = false)
    private String password;

    @Column(length = 40, nullable = false) //40 je hash od SHA1
    private String salt;

    @Autowired
    private transient HashProvider hashProvider;

    /**
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param username the username to set
     */
    public void setUserName(String username) {
        this.userName = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = this.hashProvider.computeHash(password);
    }

    /**
     * @return the provider
     */
    public HashProvider getHashProvider() {
        return hashProvider;
    }

    /**
     * @param provider the provider to set
     */
    public void setHashProvider(HashProvider provider) {
        this.hashProvider = provider;
    }
    
    public boolean hasPassword(String password){
        return hashProvider.computeHash(password + salt).equals(this.password);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    abstract public GrantedAuthority getGrantedAuthority();

}
