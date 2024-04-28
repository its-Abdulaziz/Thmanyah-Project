package com.project.itunesAPI;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000", "https://itunes-search-task.azurewebsites.net"})
@RestController
public class PostController {
    private final Service service;

    public PostController(Service service) {
        this.service = service;
    }

    @GetMapping("/findResults/{search}")
    public ResponseEntity<List<Object>> findResults(@PathVariable("search") String search) {
     return service.findResults(search);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        return service.deleteAll();
    }

}
