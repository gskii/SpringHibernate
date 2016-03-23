package ru.ncedu.gorbatovskiy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Gorbatovskiy on 22.03.2016.
 */
public class ApplicationService {
    private static final ApplicationContext APPLICATION_CONTEXT
            = new ClassPathXmlApplicationContext("spring-config.xml");

    private ApplicationService() {
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }
}
