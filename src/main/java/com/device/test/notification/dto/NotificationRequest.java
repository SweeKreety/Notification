package com.device.test.notification.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class NotificationRequest implements Serializable {
    private String user_id;
    private String type;
    private String data;
    private String app_name;
    private String additional_data;


}
