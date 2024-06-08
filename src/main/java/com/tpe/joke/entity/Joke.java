package com.tpe.joke.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Document(collection = "jokes")

@Getter
@Setter
public class Joke {

    private String id;
    private String kind;
    private String title;
    private String content;
    private List<Comment> comment;
}
