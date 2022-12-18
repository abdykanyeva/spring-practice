package com.cydeo.aspect;


import com.cydeo.dto.CourseDTO;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut(){}
//
//    @Before("myPointcut()")
//    public void log(){
//        System.out.println("Info log .......");
//    }

//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
////    public void log(){
////        System.out.println("Info log .......");
////    }

//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC(){}
//
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {} "
//        , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation(){}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {} "
//        , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation(){}
//
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint){
//
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {} "
//        , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//
//
//    }

//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC(){}
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {} "
//        , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//
//    }


    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void afterReturningGetMappingAnnotation(){}

//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning= "result")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result){
//        logger.info("Before -> Method: {}, Arguments: {}"
//        , joinPoint.getSignature(), result.toString());
//    }

//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning= "results")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results){
//        logger.info("Before -> Method: {}, Arguments: {}"
//                , joinPoint.getSignature(), results.toString());
//    }

    // CourseDTO -> Object   --> this is ok
    // List<CourseDTO> --> List<Object> --> this is not ok


//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception){
//        logger.info("Before -> Method: {}, Exception: {}"
//                , joinPoint.getSignature().toShortString(), exception.getMessage());
//    }


    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC(){}

    @Around("loggingAnnotationPC()")
    public Object anyLoggingAnnotation(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before -> Method: {} - Parameter {}"
        ,proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        logger.info("After -> Method: {}- Result: {}"
        , proceedingJoinPoint.getSignature().toShortString(), result.toString());

        return result;
    }

}
