package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger((LoggingAspect.class));

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut(){}
//
//    @Before("myPointcut()")
//    public void log(){
//        logger.info("info log..........");
//    }

//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log(){
//        logger.info("info log..........");
//    }

//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC() {
//    }
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {},Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {
//    }
//
//    @Pointcut("within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {
//    }
//
//    @Before("anyControllerOperation()||anyServiceOperation()")
//    public void BeforeControllerOrServiceOperation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {},Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {
//    }
//
//    @Before("anyDeleteControllerOperation()")
//    public void BeforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {},Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC(){}

    @Before("loggingAnnotationPC()")
    public void BeforeLoggingAnnotation(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {},Target: {}",
                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }
}
