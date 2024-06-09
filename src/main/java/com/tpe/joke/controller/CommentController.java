package com.tpe.joke.controller;

import com.tpe.joke.entity.Comment;
import com.tpe.joke.entity.Joke;
import com.tpe.joke.payload.messages.SuccessMessages;
import com.tpe.joke.payload.request.CommentRequest;
import com.tpe.joke.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/addComment/{id}")
    public ResponseEntity<String> createComment(@RequestBody Comment comment, @PathVariable ObjectId id){
        commentService.createComment(comment, id);
        return ResponseEntity.ok(SuccessMessages.COMMENT_SAVED_SUCCESSFULLY);
    }


}
