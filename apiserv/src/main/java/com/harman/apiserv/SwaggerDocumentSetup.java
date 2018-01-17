package com.harman.apiserv;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerDocumentSetup extends HttpServlet{

	private static final long serialVersionID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setTitle( "Free Parking" );
		beanConfig.setDescription( "Please enjoy our service.");
		
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		//beanConfig.setHost("www.harman.com");
		//beanConfig.setHost("www.harman.com");
		beanConfig.setBasePath("/apiserv/services");
		beanConfig.setResourcePackage( "com.harman.apiserv.services" );
		
		beanConfig.setScan(true);
	}
}
