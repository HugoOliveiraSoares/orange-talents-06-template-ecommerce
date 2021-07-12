package br.com.zupacademy.hugo.mercadolivre.components;

import org.springframework.stereotype.Component;

@Component
public class Mailer {

    public void send(String title, String body, String to, String from){

        System.out.println("title: " + title);
        System.out.println("\t" + body);
        System.out.println("From: " + from);
        System.out.println("To: " + to);

    }

}
