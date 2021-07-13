package br.com.zupacademy.hugo.mercadolivre.enums;

import br.com.zupacademy.hugo.mercadolivre.components.Mailer;
import br.com.zupacademy.hugo.mercadolivre.model.Purchase;

public enum StatusPayment {

    ERRO{
        @Override
        public StatusPayment process(Purchase purchase, Mailer mailer){
            System.out.println("ID compra: " + purchase.getId());
            System.out.println("ID usuario: " + purchase.getBuyer().getId());
            mailer.send("Falha", "AAAA DEU ERRO",
                    purchase.getBuyer().getEmail(), "sistema@mercadolivre.com");
            return StatusPayment.ERRO;
        }
    },
    SUCESSO{

        @Override
        public StatusPayment process(Purchase purchase, Mailer mailer){
            System.out.println("ID compra: " + purchase.getId());
            System.out.println("ID usuario: " + purchase.getBuyer().getId());
            return StatusPayment.SUCESSO;
        }
    };

    public abstract StatusPayment process(Purchase purchase, Mailer mailer);

}
