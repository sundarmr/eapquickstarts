package com.eap.fuse.routes;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.converter.dozer.DozerBeanMapperConfiguration;
import org.apache.camel.converter.dozer.DozerTypeConverterLoader;

@ApplicationScoped
@Startup
@ContextName("dozerContext")
public class DozerRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		DozerBeanMapperConfiguration mapper= new DozerBeanMapperConfiguration();
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("dozerMapping.xml");
		mapper.setMappingFiles(mappingFiles);
		new DozerTypeConverterLoader(getContext(),mapper);
		
		
		from("timer:typeConverter?fixedRate=true&period=1000&repeatCount=1&delay=2000")
		.to("bean:procinit")
		.to("log:tcBeforeConversion")
		.convertBodyTo(com.eap.fuse.model.SoapCustomer.class)
		.to("log:tcAfterConversion");
		
		from("timer:dozer?fixedRate=true&period=1000&repeatCount=1&delay=3000")
		.to("bean:procinit")
		.to("log:beforeConversion")
		.to("dozer:transformOrder?mappingFile=dozerMapping.xml&targetModel=com.eap.fuse.model.SoapCustomer")
		.to("log:afterConversion");
	}

}
