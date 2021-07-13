package br.com.zupacademy.hugo.mercadolivre.enums;

import br.com.zupacademy.hugo.mercadolivre.model.Purchase;
import org.springframework.web.util.UriComponentsBuilder;

public enum Gateway {

    pagseguro{
        @Override
        public String createURI(Purchase purchase, UriComponentsBuilder uriComponentsBuilder) {
            String uri = uriComponentsBuilder
                    .path("/pagseguro/{id}")
                    .buildAndExpand(purchase.getId()).toString();

            return "pagseguro.com/" + purchase.getId() + "?redirectUrl="
                    + uri;
        }
    },
    paypal{
        @Override
        public String createURI(Purchase purchase, UriComponentsBuilder uriComponentsBuilder){
            String uri = uriComponentsBuilder
                    .path("/paypal/{id}")
                    .buildAndExpand(purchase.getId()).toString();

            return "paypal.com/" + purchase.getId() + "?redirectUrl="
                    + uri;
        }
    };

    public abstract String createURI(Purchase purchase,
                    UriComponentsBuilder uriComponentsBuilder);

}
