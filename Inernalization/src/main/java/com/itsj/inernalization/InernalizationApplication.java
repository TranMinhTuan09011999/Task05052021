package com.itsj.inernalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
@RestController
public class InernalizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InernalizationApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("messages");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }

    @GetMapping("/language")
    @ResponseBody
    public String getSource(@RequestParam String locale){
        return messageSource().getMessage("hello.txt",null,new Locale(locale));
    }
}
