package br.com.zupacademy.hugo.mercadolivre.model;

import org.springframework.web.util.UriComponentsBuilder;

public enum Gateway {

    pagseguro{
        @Override
        String createURI(Purchase purchase, UriComponentsBuilder uriComponentsBuilder) {
            String uri = uriComponentsBuilder
                    .path("/pagseguro/{id}")
                    .buildAndExpand(purchase.getId()).toString();

            return "pagseguro.com/" + purchase.getId() + "?redirectUrl="
                    + uri;
        }
    },
    paypal{
        @Override
        String createURI(Purchase purchase, UriComponentsBuilder uriComponentsBuilder){
            String uri = uriComponentsBuilder
                    .path("/paypal/{id}")
                    .buildAndExpand(purchase.getId()).toString();

            return "paypal.com/" + purchase.getId() + "?redirectUrl="
                    + uri;
        }
    };

    abstract String createURI(Purchase purchase,
                    UriComponentsBuilder uriComponentsBuilder);

}
