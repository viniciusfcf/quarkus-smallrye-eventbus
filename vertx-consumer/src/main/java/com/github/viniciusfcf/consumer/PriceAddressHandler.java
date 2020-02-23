package com.github.viniciusfcf.consumer;


import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class PriceAddressHandler {

	@ConsumeEvent(value="priceAddress1", local = false)
	public void consumePrice1(Long price) {
		System.out.println("PriceAddress1Handler.consumePrice1() "+price);
	}
	
	@Incoming("channel2")
	public void consumePrice2(Long price) {
		System.out.println("PriceAddress1Handler.consumePrice2() "+price);
	}
	
	@ConsumeEvent(value="priceAddress3", local = false)
	public void consumePrice3Event(Long price) {
		System.out.println("PriceAddress1Handler.consumePrice3Event() "+price);
	}
	
	@Incoming("channel3")
	public void consumePrice3(Long price) {
		System.out.println("PriceAddress1Handler.consumePrice3() "+price);
	}
	

}