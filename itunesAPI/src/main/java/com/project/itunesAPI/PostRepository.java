package com.project.itunesAPI;

import com.fasterxml.jackson.databind.JsonNode;
import org.bson.json.JsonObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Track, String> {

}
