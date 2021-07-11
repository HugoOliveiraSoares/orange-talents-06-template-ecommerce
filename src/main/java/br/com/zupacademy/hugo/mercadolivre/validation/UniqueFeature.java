package br.com.zupacademy.hugo.mercadolivre.validation;

import br.com.zupacademy.hugo.mercadolivre.controller.form.ProductForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class UniqueFeature implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ProductForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors())
            return;

        ProductForm productForm = (ProductForm) o;
        Set<String> equalsFeatures = productForm.getEqualsFeatures();
        if (!equalsFeatures.isEmpty()){
            errors.rejectValue("features", null, "Você cadastrou " + equalsFeatures + " duas vezes");
        }
    }
}
