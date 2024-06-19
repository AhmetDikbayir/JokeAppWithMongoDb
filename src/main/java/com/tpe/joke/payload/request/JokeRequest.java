package com.tpe.joke.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class JokeRequest {

    @NotNull(message = "The kind cannot be null.")
    private String kind;

    @NotNull(message = "The title cannot be null.")
    private String title;

    @NotNull(message = "The content cannot be null.")
    private String content;
}
