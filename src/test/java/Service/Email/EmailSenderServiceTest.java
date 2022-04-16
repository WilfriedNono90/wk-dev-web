package Service.Email;

import Service.LoginService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //mockito
class EmailSenderServiceTest {

    @InjectMocks
    EmailSenderService emailSenderService;
    @Mock
    JavaMailSender javaMailSender;

    @Spy
    LoginService loginService = new LoginService();

    @Test
    void sendTestEmailTest() {
        Mockito.doNothing().when(javaMailSender).send((SimpleMailMessage) ArgumentMatchers.any());
        //Mockito.when(emailSenderService.sendTestEmailTest("wilfried")).thenReturn(true);


        boolean response = emailSenderService.sendTestEmailTest("wilfried");

        assertEquals(true, response);
    }

    @Test  //spy normal behavior
    void testName() {
        assertEquals(loginService.testName("Wil"), false);
    }

    @Test // spy fictiv behavior
    void testNameFictiv() {
        Mockito.doReturn(false).when(loginService).testName(ArgumentMatchers.any());

        assertEquals( false,loginService.testName("Wildfgfdgd"));
    }
}