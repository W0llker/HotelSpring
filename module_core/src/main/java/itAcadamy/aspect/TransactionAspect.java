package itAcadamy.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionAspect {
    @Autowired
    private Session session;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Around(value = "@annotation(CustomTransaction)")
    public Object transaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Транзакция Открылась");
        session.getTransaction().begin();
        Object o = null;
        try {
            o = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.close();
        logger.info("Транзакция закрылась");
        return o;
    }
}
