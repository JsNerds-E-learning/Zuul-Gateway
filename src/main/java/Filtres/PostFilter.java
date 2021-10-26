package Filtres;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


public class PostFilter extends ZuulFilter {

	@Override
	  public String filterType() {
	    return "post";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 2;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  @Override
	  public Object run() {
			RequestContext context = RequestContext.getCurrentContext();
	    	HttpServletResponse servletResponse = context.getResponse();
			servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());
			System.out.println("Inside POST Filter");
			System.out.println("POST FILTER : ServletResponse :"+servletResponse.getHeader("X-Sample"));
			return null;
	  }
	}