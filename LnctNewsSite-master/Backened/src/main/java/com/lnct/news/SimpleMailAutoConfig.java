package com.lnct.news;

import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceJavaMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class SimpleMailAutoConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService(AWSCredentialsProvider credentialsProvider) {
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(credentialsProvider)
                // Replace US_WEST_2 with the AWS Region you're using for
                // Amazon SES.
                .withRegion(Regions.US_EAST_2).build();
    }

    @Bean
    public JavaMailSender mailSender(AmazonSimpleEmailService ses) {
        return new SimpleEmailServiceJavaMailSender(ses);
    }
}

