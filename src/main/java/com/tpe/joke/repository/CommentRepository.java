package com.tpe.joke.repository;

import com.tpe.joke.entity.Joke;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository  extends MongoRepository<Joke, ObjectId> {
}
