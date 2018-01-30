package com.github.alanraison.sleuth.serviceb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import zipkin2.reporter.Reporter;

@Component
public class TracingInterceptor extends HandlerInterceptorAdapter {
    private final Tracer tracer;
    private final Reporter reporter;

    public TracingInterceptor(Tracer tracer, Reporter reporter) {
        this.tracer = tracer;
        this.reporter = reporter;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Span span = tracer.createSpan(request.getRequestURI());
        request.setAttribute("span", span);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        final Span span = (Span) request.getAttribute("span");
        span.stop();
        //reporter.report(span);
    }
}
