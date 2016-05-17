package com.cinq.rh.jms.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.cinq.rh.jms.resource.GreetResource;
import com.cinq.rh.jms.controllers.IndexController;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(GreetResource.class);
	}

}