package com.geslaw.appgeslaw.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

// @Configuration
public class ThymeleafConfig implements WebMvcConfigurer {

    // @Bean
    // public ViewResolver viewResolver() {
    //     org.thymeleaf.spring6.view.ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    //     resolver.setTemplateEngine(templateEngine());
    //     resolver.setCharacterEncoding("UTF-8");
    //     return resolver;
    // }

    // @Bean
    // public SpringTemplateEngine templateEngine() {
    //     SpringTemplateEngine engine = new SpringTemplateEngine();
    //     engine.setTemplateResolver(templateResolver());
    //     return engine;
    // }

    // @Bean
    // public ClassLoaderTemplateResolver templateResolver() {
    //     ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
    //     resolver.setPrefix("templates/");
    //     resolver.setSuffix(".html");
    //     resolver.setTemplateMode("HTML");
    //     resolver.setCharacterEncoding("UTF-8");
    //     return resolver;
    // }
}
