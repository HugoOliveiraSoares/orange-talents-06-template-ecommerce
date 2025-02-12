package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.form.UserFORM;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserFORM userFORM){

        User user = userFORM.convert();

        userRepository.save(user);

        return ResponseEntity.ok().build();

    }

}
