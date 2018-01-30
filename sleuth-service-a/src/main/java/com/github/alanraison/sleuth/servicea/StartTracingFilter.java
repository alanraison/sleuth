package com.github.alanraison.sleuth.servicea;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Component
public class StartTracingFilter extends ZuulFilter {
  private Tracer tracer;

  @Autowired
  public StartTracingFilter(Tracer tracer) {
    this.tracer = tracer;
  }

  @Override
  public String filterType() {
    return "routing";
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
    RequestContext ctx = RequestContext.getCurrentContext();
    ctx.put("span", tracer.createSpan("zuul span"));
    return null;
  }
}