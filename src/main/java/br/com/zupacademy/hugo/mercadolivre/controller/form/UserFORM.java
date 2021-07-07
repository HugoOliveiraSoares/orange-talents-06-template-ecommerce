package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.validation.Unique;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserFORM {

    @NotNull @NotEmpty @Email @Unique(domainClass = User.class, fieldName = "email", message = "Email já cadastrado")
    private String email;
    @NotNull @NotEmpty @Length(min = 6)
    private String password;

    // @param a senha deve ser limpa, não seve passar por hash
    public UserFORM(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User convert() {
        return new User(this.email, new BCryptPasswordEncoder().encode(this.password));
    }
}
