package com.isep.code;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

public class GmapsCall {
    private String origin = "48.855324583368930%2C2.364427008194676";
    private String destination = "48.84524303335598%2C2.3528580641779517";
    private String mode = "transit";
    private String key = "AIzaSyBv1RNdSPkEVqTjPP6sL5y9KOKUDJLqxPg";
    private String gmapsURL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin
            + "&destinations="
            + destination + "&mode=" + mode + "&key=" + key;

    public void gmapsCallMethod() {
        System.out.println(gmapsURL);
        WebClient gmapsClient = WebClient.builder().build();
        ResponseSpec responseSpec = gmapsClient.get().uri(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=48.855324583368930%2C2.364427008194676&destinations=48.84524303335598%2C2.3528580641779517&mode=transit&key=AIzaSyBv1RNdSPkEVqTjPP6sL5y9KOKUDJLqxPg")
                .retrieve();
        responseSpec.bodyToMono(String.class)
                .subscribe(response -> {
                    System.out.println(response);
                });
        System.out.println(responseSpec.toString());
    }

}