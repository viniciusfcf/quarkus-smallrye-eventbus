package com.github.viniciusfcf;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;

import io.quarkus.runtime.StartupEvent;
import io.vertx.axle.core.Vertx;
import io.vertx.axle.core.eventbus.EventBus;

@ApplicationScoped
public class PriceProducer {

	@Inject
	EventBus bus;

	@Inject
	Vertx vertx;

	private Random random = new Random();

	public void onStart(@Observes StartupEvent event) {
		vertx.setPeriodic(1000, id -> {
			long nextLong = random.nextLong();
			System.out.println("Enviando para priceAddress 1 e 2: " + nextLong);
			bus.publish("priceAddress1", nextLong);
			bus.publish("priceAddress2", nextLong);

		});
	}

	@Outgoing("channel3")
	public PublisherBuilder<Long> priceAdress3() {
		System.out.println(">>>PriceProducer.priceAdress3()");
		return ReactiveStreams.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
	}
}
