package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void wiringAndValues() {
        assertNotNull(notificationManager);

        NotificationService email = notificationManager.getEmailService();
        NotificationService sms = notificationManager.getSmsService();
        assertNotNull(email);
        assertNotNull(sms);

        EmailNotificationService emailImpl = (EmailNotificationService) email;
        SmsNotificationService smsImpl = (SmsNotificationService) sms;

        assertEquals("smtp.gmail.com", emailImpl.getSmtpServer());
        assertEquals(587, emailImpl.getPort());
        assertEquals("SKT", smsImpl.getProvider());

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}