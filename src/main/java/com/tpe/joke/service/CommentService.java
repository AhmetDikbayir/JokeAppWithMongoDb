package com.tpe.joke.service;

import com.tpe.joke.entity.Comment;
import com.tpe.joke.entity.Joke;
import com.tpe.joke.payload.request.CommentRequest;
import com.tpe.joke.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public void createComment(Comment comment, ObjectId id) {
        commentRepository.save(comment);
        mongoTemplate.update(Joke.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("comment").value(comment))
                .first();
    }

}
