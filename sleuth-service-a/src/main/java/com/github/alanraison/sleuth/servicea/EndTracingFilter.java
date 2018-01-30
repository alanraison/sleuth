package com.github.alanraison.sleuth.servicea;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.sleuth.Span;

public class EndTracingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        Span span = (Span) RequestContext.getCurrentContext().get("span");
        span.stop();
        return null;
    }
}
