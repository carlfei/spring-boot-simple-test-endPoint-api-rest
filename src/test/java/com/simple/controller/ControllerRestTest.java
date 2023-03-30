package com.simple.controller;

import com.google.gson.Gson;
import com.simple.model.Coche;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ControllerRestTest {

    List<Coche> listCoche = new ArrayList<>();
    private List<Coche> methodCreation(){
        for(int i=1; i<5; i++){
            listCoche.add(new Coche(i,"model-"+""+i+""));
        }
        return listCoche;
    }

    private String methodCreation(int j){
        for(int i=1; i<5; i++){
            listCoche.add(new Coche(i,"model-"+""+i+""));
        }
        return listCoche.get(j).toString();
    }


    @Test
    void testStateRestBuilderAll(){

        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:9090/coches/all")
                .build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        Gson gson = new Gson();
        String jsonString = gson.toJson(methodCreation());
        assertEquals(jsonString,response);
    }


    @Test
    void testStateRestBuilderId(){
        int indice = 1;
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:9090/coches/"+""+indice)
                .build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        assertEquals(methodCreation(indice),response);

    }

}