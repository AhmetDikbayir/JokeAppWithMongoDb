package com.tpe.joke.service;

import com.tpe.joke.entity.Comment;
import com.tpe.joke.entity.Joke;
import com.tpe.joke.exceptions.ResourceNotFoundException;
import com.tpe.joke.payload.messages.ErrorMessages;
import com.tpe.joke.payload.messages.SuccessMessages;
import com.tpe.joke.repository.JokeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JokeService {

    private final JokeRepository jokeRepository;

    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }


    public void addJoke(Joke joke) {
        jokeRepository.save(joke);
    }



    public Optional<Joke> getJokeById(ObjectId id) {
        return jokeRepository.findById(id);
    }

    public String deleteById(ObjectId id) {
        jokeRepository.deleteById(id);
        return SuccessMessages.JOKE_DELETED_SUCCESSFULY;
    }

    public Joke addComment(ObjectId id, Comment comment) {
        Optional<Joke> jokeOpt = jokeRepository.findById(id);
        if (jokeOpt.isPresent()) {
            Joke joke = jokeOpt.get();
            joke.getComment().add(comment);
            return jokeRepository.save(joke);
        } else {
            throw new RuntimeException("Joke not found with id: " + id);
        }
    }

    public List<Comment> getAllComments(ObjectId id) {
        Optional<Joke> joke = jokeRepository.findById(id);
        return joke.get().getComment();
    }
}
