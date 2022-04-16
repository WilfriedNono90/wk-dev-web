package Service;

import com.mysql.cj.log.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //mockito
class LoginServiceTest {
    static  LoginService loginService1;
    @Spy
    static LoginService loginService = new LoginService() ;

    @BeforeAll
    static void  initialiseValue() {
        loginService1 = new LoginService();
    }

    /*
    @BeforeEach

    @AfterAll

    @AfterEach
    */

    @Test
    void testLenghName() {

        String nameTest = "Wil";

        boolean response = loginService1.testName(nameTest);
        assertEquals(true, response);
        assertTrue(response);
    }

    @Test
    void testEmailWithFalscheAdresse() {

        //Mockito.when(loginService.testEmail(ArgumentMatchers.any())).thenReturn(false);
        //Mockito.when(loginService.testEmail("wilfried.nono@gmail.com")).thenReturn(true);

        Mockito.doReturn(true).when(loginService).testEmail(ArgumentMatchers.any());
        String email = "1213456";

        boolean result = loginService.testEmail(email);

        assertEquals(false, result);
    }

    @Test
    void testEmailAvecMajuscule() {
        String email = "Wilfr@gmail.com";

        boolean result = loginService.testEmail(email);

        assertEquals(true, result);
    }

    @Test
    void testEmailAvecUniquementMiniscule() {
        String email = "wilfr@gmail.com";

        boolean result = loginService.testEmail(email);

        assertEquals(true, result);
    }
}