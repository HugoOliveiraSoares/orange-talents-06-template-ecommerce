package br.com.zupacademy.hugo.mercadolivre.model;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty
    private String password;
    @PastOrPresent
    private LocalDateTime instant = LocalDateTime.now();

    @Deprecated
    public User() {
    }

    /*
     * @param email string em formato de email
     * @param senha string em texto limpo
     */
    public User(@Valid String email, String password) {
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
