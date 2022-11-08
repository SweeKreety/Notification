package com.device.test.notificationtemplates.service;


import com.device.test.notificationtemplates.dto.NotificationTemplatesRequest;
import com.device.test.notificationtemplates.model.NotificationTemplates;
import com.device.test.notificationtemplates.repository.NotificationTemplatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationTemplatesService {

    @Autowired
    private NotificationTemplatesRepository notificationTemplatesRepository;

    //saving all notification template
    public NotificationTemplates saveNotificationTemplates(NotificationTemplatesRequest notificationTemplatesRequest) {
        //mapper
        NotificationTemplates notificationTemplates = new NotificationTemplates();
        notificationTemplates.setTitle(notificationTemplatesRequest.getTitle());
        notificationTemplates.setDescription(notificationTemplatesRequest.getDescription());
        notificationTemplates.setSource_type(notificationTemplatesRequest.getSource_type());
        notificationTemplates.setContent_title(notificationTemplatesRequest.getContent_title());
        notificationTemplates.setContent_body(notificationTemplatesRequest.getContent_body());
        notificationTemplates.setAdditional_data(notificationTemplatesRequest.getAdditional_data());
        return notificationTemplatesRepository.save(notificationTemplates);
    }

    //getting all notification template
    public List<NotificationTemplates> getAllNotificationTemplates(){
        List<NotificationTemplates> notificationTemplates= new ArrayList<>();
        Streamable.of(notificationTemplatesRepository.findAll())
                .forEach(notificationTemplates::add);
        return notificationTemplates;
    }

    //deleting notification templates
    public void deleteAll() {
        notificationTemplatesRepository.deleteAll();
    }

    //finding notification template by ID
    public Optional<NotificationTemplates> getNotificationTemplates(Integer id){
       return notificationTemplatesRepository.findById(id);
    }

    //deleting notification templates by id
    public void deleteNotificationTemplate(Integer id){
        notificationTemplatesRepository.deleteById(id);
    }

}
