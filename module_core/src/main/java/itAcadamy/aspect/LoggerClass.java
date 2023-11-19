package itAcadamy.aspect;

import itAcadamy.exception.LoggerException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;


@Component
@Aspect
@Slf4j
public class LoggerClass {
    @Around("@annotation(annotation.LoggerAnnotation))")
    public Object logger(ProceedingJoinPoint joinPoint) {
        Object objects;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String nameClass = joinPoint.getSignature().getDeclaringTypeName();
        log.info("Запущен контроллер "+ nameClass+ ", Имя метода "+ method.getName());
        try {
            objects = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("Контроллер выкинул ошибку " + nameClass+ ", Имя метода "+ method.getName());
            throw new LoggerException(e.getMessage());
        }
        log.info("Закончил работу контроллер "+ nameClass+ " имя метода "+ method.getName());
        return objects;
    }
}
