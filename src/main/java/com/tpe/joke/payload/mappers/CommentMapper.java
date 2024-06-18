package com.tpe.joke.payload.mappers;

import com.tpe.joke.entity.Comment;
import com.tpe.joke.payload.request.CommentRequest;
import com.tpe.joke.payload.response.CommentResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CommentMapper {

    public Comment mapCommentRequestToComment(CommentRequest commentRequest){
        return Comment.builder()
                .title(commentRequest.getTitle())
                .body(commentRequest.getBody())
                .build();
    }

    public CommentResponse mapCommentToCommentResponse(Comment comment){
        return CommentResponse.builder()
                .title(comment.getTitle())
                .body(comment.getBody())
                .build();
    }
}
