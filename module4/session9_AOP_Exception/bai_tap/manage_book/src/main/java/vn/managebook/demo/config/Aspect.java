package vn.managebook.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Pointcut("execution(* vn.managebook.demo.controllers.BookController.*(..))")
    public void bookControllerMethod(){}

    int count = 1;
    @Before("bookControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }

    @Pointcut("execution(* vn.managebook.demo.controllers.BookController.bookList(..))")
    public void bookControllerMethod2(){}

    @After("bookControllerMethod2()")
    public void afterCallMethod2(){
        System.err.println("Customer come: " + count++);
    }
}
