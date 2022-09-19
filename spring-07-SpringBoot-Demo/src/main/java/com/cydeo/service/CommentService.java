package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
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

   private final AppConfigData appConfigData;


   private final DBConfigData dbConfigData;

    public CommentService(@Qualifier("EMAIL")CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){
        // save in the database
        commentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);

    }

    public void printConfigData(){
        System.out.println(appConfigData.getUsername());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }

    public void printDBConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getType());
        System.out.println(dbConfigData.getPassword());
    }
}
