/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.view.conv;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter example. This implementation is defined as a bean component and is
 * referenced in facelets using the binding attribute in the h:converter tag.
 * @author user
 */
@Component
public class IntConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return Integer.parseInt(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return (o != null)?o.toString():"";
    }
    
}
