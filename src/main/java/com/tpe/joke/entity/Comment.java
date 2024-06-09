package com.tpe.joke.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.DeleteQuery;

@Document(collection = "comments")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private ObjectId id;

    private String title;
    private String body;


}
