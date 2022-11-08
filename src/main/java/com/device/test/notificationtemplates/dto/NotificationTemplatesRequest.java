package com.device.test.notificationtemplates.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NotificationTemplatesRequest implements Serializable {
    private String title;
    private String description;
    private String source_type;
    private String content_title;
    private String content_body;
    private String additional_data;

}
