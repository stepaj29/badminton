/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dao.GenericDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Authentication provider pro Flexiblu 2
 * @author Pavel Micka
 */
//Configuration in applicationContext-security.xml
public class AuthenticationService extends AbstractUserDetailsAuthenticationProvider {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractUserDetailsAuthenticationProvider.class);
    private GenericDao genericDAO;
    private TransactionTemplate transactionTemplate;

    public AuthenticationService() {
        this.setUserCache(new NullUserCache());
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails ud, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        // do nothing
    }

    /**
     * Krome specifikace z nadtridy prida v pripade uspesneho prihlaseni do sessionHolderu pod klic "user" daneho uzivatele
     * @param username
     * @param upat
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        //only public methods can be marked as transactional
        return (UserDetails) transactionTemplate.execute(new TransactionCallback() {

            @Override
            public Object doInTransaction(TransactionStatus status) { 
                try {
                    UserDetails ud = null;

                    cz.cvut.kbss.wpa.badminton.bo.User u = genericDAO.getByPropertyUnique("username", username, cz.cvut.kbss.wpa.badminton.bo.User.class);
                    String password = (String) upat.getCredentials();
                    if (u == null || !u.hasPassword(password)) {
                        AuthenticationException e = new BadCredentialsException("Neplatne uzivatelske udaje");
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY, e);
                        throw e;
                    } else {
                        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
                        auths.add(new GrantedAuthorityImpl("ROLE_USER"));
                        if(u.isAdmin()){
                            auths.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
                        }
                        ud = new User(u.getUserName(), u.getPassword(), auths);
                    }
                    return ud;
                } catch(AuthenticationException e){
                    status.setRollbackOnly();
                    throw e;
                }catch (Exception e) {
                    LOG.error("Error occured during retrieveUser call", e);
                    status.setRollbackOnly();
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setGenericDAO(GenericDao genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    
    
}
