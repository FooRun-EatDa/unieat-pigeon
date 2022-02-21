package com.foorun.unieat.pigeon;

import com.foorun.unieat.pigeon.config.properties.mail.MailProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.PasswordAuthentication;

@SpringBootTest
class UnieatPigeonApplicationTests {
    @Autowired
    private MailProperties mailProperties;

    @Test
    void contextLoads() {
        System.out.println("mailProperties --> " + mailProperties);

    }

}
