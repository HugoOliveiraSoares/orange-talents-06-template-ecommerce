package br.com.zupacademy.hugo.mercadolivre.components;

import br.com.zupacademy.hugo.mercadolivre.model.StatusPurchase;
import org.springframework.stereotype.Component;

@Component
public class Mailer {

    public void send(String title, String body, String to, String from){

        System.out.println("title: " + title);
        System.out.println("\t" + body);
        System.out.println("From: " + from);
        System.out.println("To: " + to);

    }

    public void sendEmailPurchase(String to, String from, StatusPurchase statusPurchase){

        if (statusPurchase.equals(StatusPurchase.INICIADA)) {
            System.out.println("title: Compra Iniciada");
            System.out.println("\t O usuario " + from + " deseja comprar um produto seu!");
        }else{
            System.out.println("title: Compra Finalizada");
            System.out.println("\t O usuario " + from + " comprou um produto seu!");
        }

        System.out.println("From: " + from);
        System.out.println("To: " + to);

    }

}
