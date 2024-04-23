package com.project.itunesAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor

public class Service {
    public Service() {
    }
    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    public ResponseEntity<List<Object>> findResults(String search) {

        String linkToSend = "https://itunes.apple.com/search" + "?term=" + search + "&entity=podcast";

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(linkToSend, String.class);
            // Manually deserialize using ObjectMapper
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response.getBody());
                List<Object> filteredResults = new ArrayList<>();

                // the results I want are under "results" in the JSON response
                for (JsonNode result : jsonResponse.get("results")) {
                    JsonNode filteredResult = objectMapper.createObjectNode()
                            .put("artistName", result.has("artistName") ? result.get("artistName").asText("") : "")
                            .put("collectionName", result.has("collectionName") ? result.get("collectionName").asText("") : "")
                            .put("trackId", result.has("trackId") ? result.get("trackId").asText("") : "")
                            .put("collectionViewUrl", result.has("collectionViewUrl") ? result.get("collectionViewUrl").asText("") : "")
                            .put("artworkUrl600", result.has("artworkUrl600") ? result.get("artworkUrl600").asText("") : "");

                    Track track = new Track(result.get("artistName").asText(""),result.get("collectionName").asText("")
                                          , result.get("trackId").asText(""),result.get("collectionViewUrl").asText(""),
                                            result.get("artworkUrl600").asText(""));
                    ResponseEntity<Object> objectResponseEntity = saveTrack(track);
                    if(!(objectResponseEntity.getStatusCode().value() == 201))
                        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                    filteredResults.add(filteredResult);
                }
                return new ResponseEntity<>(filteredResults, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (RestClientException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

    }

    public ResponseEntity<Object> saveTrack(Track x) {
        try {
            if (x != null) {
                postRepository.save(x);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    public ResponseEntity<Object> deleteAll() {
        postRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}