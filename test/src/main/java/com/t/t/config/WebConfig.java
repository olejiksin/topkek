package com.t.t.config;

import com.t.t.controllerAndServlet.CountServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CountServlet(), "/servlet/*");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
