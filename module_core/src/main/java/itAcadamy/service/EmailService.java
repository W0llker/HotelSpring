package itAcadamy.service;

import itAcadamy.entity.OrderHotel;
import itAcadamy.entity.PatternMessageEmail;
import itAcadamy.exception.EmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendOrderToMail(OrderHotel orderHotel) {
        try {
            PatternMessageEmail patternMessageEmail = new PatternMessageEmail(orderHotel);
            var mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
            message.setFrom("Hotel");
            message.setTo(orderHotel.getClient().getEmail());
            message.setSubject("Оплата успешно прошла");
            message.setText(patternMessageEmail.getMessage(), true);
            javaMailSender.send(mimeMessage);
            log.info("Сообщение отправленно");
        } catch (Exception e) {
            throw new EmailException("Сообщение не дошло");
        }
    }
}
