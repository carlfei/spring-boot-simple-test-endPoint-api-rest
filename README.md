
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



![imagen](https://user-images.githubusercontent.com/49040356/228809978-816d9711-deee-460c-94b4-e3fb73444095.png)







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



![imagen](https://user-images.githubusercontent.com/49040356/228810110-69a29ae1-1cae-4392-a70e-eda880f13fe8.png)





![imagen](https://user-images.githubusercontent.com/49040356/228810420-66098f6a-e356-4f49-8145-d1f81f982915.png)






