package com.tpe.joke.controller;

import com.tpe.joke.entity.Comment;
import com.tpe.joke.entity.Joke;
import com.tpe.joke.payload.messages.SuccessMessages;
import com.tpe.joke.payload.request.JokeRequest;
import com.tpe.joke.repository.JokeRepository;
import com.tpe.joke.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @GetMapping("/allJokes")
    public List<Joke> getAllJokes(){
        return jokeService.getAllJokes();
    }

    @GetMapping("/getJokeById/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable ObjectId id) {
        Optional<Joke> joke = jokeService.getJokeById(id);
        return joke.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/addJoke")
    public ResponseEntity<String>addJoke(@RequestBody Joke joke){
        jokeService.addJoke(joke);
        return ResponseEntity.ok(SuccessMessages.JOKE_SAVED_SUCCESSFULLY);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ObjectId id){
        return new ResponseEntity<>(jokeService.deleteById(id), HttpStatus.OK);
    }

    @PostMapping("/comments/{id}")
    public ResponseEntity<Joke> addComment(@PathVariable ObjectId id, @RequestBody Comment comment) {
        Joke updatedJoke = jokeService.addComment(id, comment);
        return ResponseEntity.ok(updatedJoke);
    }

    //Get All Comments
    @GetMapping("/getComments/{id}")
    public ResponseEntity<List<Comment>> getAllComment(@PathVariable ObjectId id){
        List<Comment> comments = jokeService.getAllComments(id);
        return ResponseEntity.ok(comments);
    }

}
