/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

/**
 *
 * @author jan
 */
@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

    @Override
    public GrantedAuthority getGrantedAtuhority() {
        return new GrantedAuthorityImpl("ROLE_ADMIN");
    }
    
}
