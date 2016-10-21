package com.eap.fuse.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.velocity.VelocityConstants;
import org.apache.velocity.VelocityContext;

public class InitProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setBody("");
        exchange.getIn().setHeader("name", "Sundar");
        Map<String, Object> variableMap = new HashMap<String, Object>();
        Map<String, Object> headersMap = new HashMap<String, Object>();
        headersMap.put("name", "Sundar");
        variableMap.put("headers", headersMap);
        variableMap.put("body", "Monday");
        variableMap.put("exchange", exchange);
        VelocityContext velocityContext = new VelocityContext(variableMap);
        exchange.getIn().setHeader(VelocityConstants.VELOCITY_CONTEXT, velocityContext);
        exchange.setProperty("item", "7");
		
	}

}
