package com.example.muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitLogger {

    private static final Logger logger = LoggerFactory.getLogger(VisitLogger.class);
    private static int visitCount = 0;

    @Before("execution(* com.example.muon_sach.controller..*(..))")
    public void logVisit(JoinPoint joinPoint) {
        visitCount++;
        logger.info("Visitor #{} - Method accessed: {}", visitCount, joinPoint.getSignature());
    }
}
