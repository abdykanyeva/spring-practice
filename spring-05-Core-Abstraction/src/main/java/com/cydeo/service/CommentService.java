package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class CommentService {

   private final CommentNotificationProxy commentNotificationProxy;
   private final CommentRepository commentRepository;

    public CommentService(CommentNotificationProxy commentNotificationProxy, @Qualifier("emailCommentNotificationProxy") CommentRepository commentRepository) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment){
        // save in the database
        commentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);

    }
}
