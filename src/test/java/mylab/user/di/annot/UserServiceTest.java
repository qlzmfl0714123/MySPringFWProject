package mylab.user.di.annot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*; // ← JUnit5 Assertions

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("DI 주입 및 기능 동작 검증")
    void testUserService() {
        assertNotNull(userService);

        assertNotNull(userService.getUserRepository());
        assertEquals("MySQL", userService.getUserRepository().getDbType());

        assertNotNull(userService.getSecurityService());

        assertTrue(userService.registerUser("u100", "홍길동", "pw1234"));
    }
}