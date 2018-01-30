package com.github.alanraison.sleuth.serviceb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TracingInterceptor interceptor;
    @Bean
    public AsyncReporter reporter(@Value("${spring.zipkin.baseUrl}") String zipkinUrl) {
        return AsyncReporter.create(OkHttpSender.create(zipkinUrl + "/api/v2/spans"));
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
