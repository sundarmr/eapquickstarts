package com.eap.fuse.servlet;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.camel.CamelContext;

@WebServlet("/hello")
public class CamelServlet extends HttpServlet {
    
	@Resource(mappedName="java:jboss/camel/context/cdiContext")
	CamelContext context;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestBody = context.createProducerTemplate().requestBody("direct:start",request.getParameter("name"),String.class);
    	response.getWriter().write(requestBody);
    }
}
