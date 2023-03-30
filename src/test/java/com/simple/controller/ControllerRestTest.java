package com.simple.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ControllerRestTest {

    @Test
    void testStateRestBuilderAll(){

        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:9090/coches/all")
                .build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        assertEquals("[{\"id\":1,\"tipo\":\"model-1\"}" +
                ",{\"id\":2,\"tipo\":\"model-2\"},{\"id\":3,\"tipo\":\"model-3\"}" +
                ",{\"id\":4,\"tipo\":\"model-4\"}]"
                ,response);

    }


    @Test
    void testStateRestBuilderId(){
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:9090/coches/1")
                .build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        assertEquals("Coche(id=2, tipo=model-2)",response);

    }

}