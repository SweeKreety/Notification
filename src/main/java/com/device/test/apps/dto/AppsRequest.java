package com.device.test.apps.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AppsRequest implements Serializable {
    private String name;
    private String private_key;
}
