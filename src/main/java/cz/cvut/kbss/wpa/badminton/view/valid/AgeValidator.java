/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.badminton.view.valid;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Custom validator example. This validator is defined using the jsf's @FacesValidator
 * and it is referenced by the validatorId attribute in the h:validator.
 * @author user
 */
@FacesValidator(value = "ageValidator")
public class AgeValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (o == null || "".equals(o)) {
            return;
        }

        Long l = Long.valueOf(String.valueOf(o));
        if (l < 0) {
            throw new ValidatorException(new FacesMessage("Input value should be bigger then 0", "the age parameter is a posistive number."));
        }
        if (l > 200) {
            throw new ValidatorException(new FacesMessage("Input value should be less then 200", "maximum age is 200."));
        }
    }
}
