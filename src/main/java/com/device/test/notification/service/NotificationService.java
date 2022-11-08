package com.device.test.notification.service;

import com.device.test.notification.dto.NotificationRequest;
import com.device.test.notification.model.Notification;
import com.device.test.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Service marks class that performs certain service like executing business logic.
//DAO means data access object which isolates app/business layer from persistence layer.
@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    //saving all notification
    public Notification saveNotification(NotificationRequest notificationRequest) {
        //mapper
        Notification notification = new Notification();
        notification.setData(notificationRequest.getData());
        notification.setType(notificationRequest.getType());
        return notificationRepository.save(notification);
    }

    //getting all notification
    public List<Notification> getAllNotification(){
        List<Notification> notification= new ArrayList<>();
        Streamable.of(notificationRepository.findAll())
                .forEach(notification::add);
        return notification;
    }

    //deleting notifications
    public void deleteAll() {
        notificationRepository.deleteAll();
    }


    //finding all notification
    public List<Notification> findAllNotification() {
        return notificationRepository.findAll();
    }

    //finding notification by ID
    public Optional<Notification> getNotification(String id) {
        return Optional.ofNullable(notificationRepository.findById(Integer.parseInt(id)));
    }

    //updating notification
    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    //deleting notification by ID
    public void deleteNotification(Integer id){
        notificationRepository.deleteById(id);
    }
}
    