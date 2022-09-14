package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CommentService {

   private final CommentNotificationProxy commentNotificationProxy;
   private final CommentRepository commentRepository;

    public CommentService(@Qualifier("EMAIL")CommentNotificationProxy commentNotificationProxy,  CommentRepository commentRepository) {
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
