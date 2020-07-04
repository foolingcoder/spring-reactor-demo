package com.spring.reactor.demo;

import com.spring.reactor.demo.consumer.NotificationConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.bus.EventBus;
import static reactor.bus.selector.Selectors.$;

@SpringBootApplication
public class SpringReactorDemoApplication implements CommandLineRunner {
	@Autowired
	private EventBus eventBus;

	@Autowired
	private NotificationConsumer notificationConsumer;

	@Override
	public void run(String... args) throws Exception {
		eventBus.on($("notificationConsumer"), notificationConsumer);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringReactorDemoApplication.class, args);
	}

}
