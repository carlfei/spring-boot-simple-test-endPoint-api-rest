


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



![imagen](https://user-images.githubusercontent.com/49040356/228890059-21b7573a-69e3-4857-b62d-879ff8d15dca.png)










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

![imagen](https://user-images.githubusercontent.com/49040356/228890286-28aef42d-29cc-4d45-a006-3c883143bc23.png)





![imagen](https://user-images.githubusercontent.com/49040356/228810420-66098f6a-e356-4f49-8145-d1f81f982915.png)






