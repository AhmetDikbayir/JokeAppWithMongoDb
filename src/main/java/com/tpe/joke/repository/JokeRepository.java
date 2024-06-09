package com.tpe.joke.repository;

import com.tpe.joke.entity.Joke;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends MongoRepository<Joke, ObjectId> {
}
