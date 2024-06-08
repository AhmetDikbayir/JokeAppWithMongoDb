package com.tpe.joke.entity;



import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Document(collection = "jokes")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Joke {

    @Id
    private ObjectId id;
    private String kind;
    private String title;
    private String content;

    @DocumentReference
    private List<Comment> comment;
}
