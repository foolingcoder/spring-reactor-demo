package com.spring.reactor.demo.consumer;
import com.spring.reactor.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;

import com.spring.reactor.demo.pojo.NotificationData;

@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {
    @Autowired
    private NotificationService notificationService;

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {
        NotificationData notificationData = notificationDataEvent.getData();
        try {
            notificationService.initiateNotification(notificationData);
        } catch (InterruptedException e) {
        }
    }
}
