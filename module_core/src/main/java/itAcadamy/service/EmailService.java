package itAcadamy.service;

import itAcadamy.entity.OrderHotel;
import itAcadamy.exception.EmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Slf4j
@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendOrderToMail(OrderHotel orderHotel) {
        try {
            var mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
            message.setTo(orderHotel.getClient().getEmail());
            message.setSubject("Оплата успешно прошла");
            Context context = new Context();
            context.setVariable("order", orderHotel);
            String htmlContent = templateEngine.process("payment", context);
            message.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
            log.info("Сообщение отправленно");
        } catch (Exception e) {
            throw new EmailException("Сообщение не дошло");
        }
    }
}
