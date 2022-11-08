package com.device.test.notification.controller;

import com.device.test.notification.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import com.device.test.notification.dto.NotificationRequest;
import com.device.test.notification.model.Notification;
import com.device.test.notification.repository.NotificationRepository;
import com.device.test.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    private NotificationRepository notificationRepository;


    @GetMapping("/notifications")
    public List<Notification> getAllNotification(){
        return notificationService.getAllNotification();
    }

    @PostMapping("/notifications")
        public Notification saveNotification(@RequestBody NotificationRequest notification){
            return notificationService.saveNotification(notification);
    }

    @RequestMapping("/notification/{id}")
        public Optional<Notification> notification(@PathVariable String id){
        return notificationService.getNotification(id);
    }
    @DeleteMapping("/notifications")
    public void deleteNotification(){
       notificationService.deleteAll();
    }

    @PutMapping("/notification/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Integer id, @RequestBody Notification notification) {
        Notification updateNotification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification does not exist with id: " + id));

        updateNotification.setUser_id(notification.getUser_id());
        updateNotification.setApp_name(notification.getApp_name());
        updateNotification.setData(notification.getData());
        updateNotification.setType(notification.getType());
        updateNotification.setAdditional_data(notification.getAdditional_data());

        notificationRepository.save(updateNotification);

        return ResponseEntity.ok(updateNotification);
    }
    @RequestMapping(value= "/notification/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteApp(@PathVariable Integer id) {
        notificationService.deleteNotification(id);
        return "Notification has been deleted successfully";

    }
}
