package com.tpe.joke.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

public class Comment {
    private String title;
    private String body;
}
