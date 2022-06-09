package com.mirea.homedepot.catalogservice.core.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirea.homedepot.catalogservice.core.model.entity.LogEntity;
import com.mirea.homedepot.catalogservice.core.model.entity.UserEntity;
import com.mirea.homedepot.catalogservice.core.repository.LogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class LoggingAspect {

    private final LogRepository logRepository;

    @Pointcut("within(com.mirea.homedepot.catalogservice.core.controller.LoginController)")
    public void loginController() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }

    @Around("loginController()")
    public Object loginControllerLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        String name = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

        Object[] array = pjp.getArgs();

        LogEntity logEntityBefore = new LogEntity(null, LocalDateTime.now(), methodName, className, name);
        log.info(
            logEntityBefore.getCreateDttm() + " Вызван метод: " + logEntityBefore.getClassName() + "." + logEntityBefore.getMethodName() + " ()" +
                " с аргументами" + mapper.writeValueAsString(array) + " Пользователем " + name);
        logRepository.insert(logEntityBefore);

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        LogEntity logEntityAfter = new LogEntity(null, LocalDateTime.now(), methodName, className, name);
        log.info(
            logEntityAfter.getCreateDttm() + " Завершен метод : " + logEntityAfter.getClassName() + "." + logEntityAfter.getMethodName() + " ()" +
                " с аргументами" + mapper.writeValueAsString(array) + " Пользователем " + name);
        logRepository.insert(logEntityAfter);

        return object;
    }

    @Around("restController()")
    public Object restControllerLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Object[] array = pjp.getArgs();

        LogEntity logEntityBefore = new LogEntity(null, LocalDateTime.now(), methodName, className, userEntity.getUsername());
        log.info(
            logEntityBefore.getCreateDttm() + " Вызван метод: " + logEntityBefore.getClassName() + "." + logEntityBefore.getMethodName() + " ()" +
                " с аргументами" + mapper.writeValueAsString(array) + " Пользователем " + logEntityBefore.getUserName());
        logRepository.insert(logEntityBefore);

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        LogEntity logEntityAfter = new LogEntity(null, LocalDateTime.now(), methodName, className, userEntity.getUsername());
        log.info(
            logEntityAfter.getCreateDttm() + " Завершен метод : " + logEntityAfter.getClassName() + "." + logEntityAfter.getMethodName() + " ()" +
                " с аргументами" + mapper.writeValueAsString(array) + " Пользователем " + logEntityAfter.getUserName());
        logRepository.insert(logEntityAfter);

        return object;
    }

}