package com.spring.reactor.demo.service;

import com.spring.reactor.demo.pojo.NotificationData;

public interface NotificationService {
    void initiateNotification(NotificationData notificationData)
            throws InterruptedException;
}
