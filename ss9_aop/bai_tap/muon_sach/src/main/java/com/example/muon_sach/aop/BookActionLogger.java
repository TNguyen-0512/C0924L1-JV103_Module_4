package com.example.muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookActionLogger {

    private static final Logger logger = LoggerFactory.getLogger(BookActionLogger.class);

    @AfterReturning("execution(* com.example.muon_sach.service.BookService.borrowBook(..)) || " +
            "execution(* com.example.muon_sach.service.BookService.returnBook(..))")
    public void logBookChange(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Book action executed: {} - Arguments: {}", method, args);
    }
}
