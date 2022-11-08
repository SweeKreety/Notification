package com.device.test.notificationtemplates.controller;

import com.device.test.notification.dto.NotificationRequest;
import com.device.test.notification.exception.ResourceNotFoundException;
import com.device.test.notification.model.Notification;
import com.device.test.notificationtemplates.dto.NotificationTemplatesRequest;
import com.device.test.notificationtemplates.model.NotificationTemplates;
import com.device.test.notificationtemplates.repository.NotificationTemplatesRepository;
import com.device.test.notificationtemplates.service.NotificationTemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NotificationTemplatesController {
    @Autowired
    private NotificationTemplatesService notificationTemplatesService;
    private NotificationTemplatesRepository notificationTemplatesRepository;

    @GetMapping("/notification-templates")
    public List<NotificationTemplates> getAllNotificationTemplates(){
        return notificationTemplatesService.getAllNotificationTemplates();
    }
    @PostMapping("/notification-templates")
    public NotificationTemplates save(@RequestBody NotificationTemplatesRequest notificationTemplates){
        return notificationTemplatesService.saveNotificationTemplates(notificationTemplates);
    }
    @RequestMapping("/notification-template/{id}")
    public Optional<NotificationTemplates> notificationTemplates(@PathVariable String id){
        return notificationTemplatesService.getNotificationTemplates(Integer.valueOf(id));
    }
    @DeleteMapping("/notification-templates")
    public void deleteNotificationTemplates(){
        notificationTemplatesService.deleteAll();
    }

    @PutMapping("notification-template/{id}")
    public ResponseEntity<NotificationTemplates> updateNotificationTemplates(@PathVariable Integer id, @RequestBody NotificationTemplates notificationTemplates) {
        NotificationTemplates updateNotificationTemplates = notificationTemplatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification Template not exist with id: " + id));


        updateNotificationTemplates.setTitle(notificationTemplates.getTitle());
        updateNotificationTemplates.setDescription(notificationTemplates.getDescription());
        updateNotificationTemplates.setSource_type(notificationTemplates.getSource_type());
        updateNotificationTemplates.setContent_title(notificationTemplates.getContent_title());
        updateNotificationTemplates.setContent_body(notificationTemplates.getContent_body());
        updateNotificationTemplates.setAdditional_data(notificationTemplates.getAdditional_data());

        notificationTemplatesRepository.save(updateNotificationTemplates);

        return ResponseEntity.ok(updateNotificationTemplates);
    }
    @RequestMapping(value= "/notification-template/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteApp(@PathVariable Integer id) {
        notificationTemplatesService.deleteNotificationTemplate(id);
        return "Notification Template has been deleted successfully";

    }
}
