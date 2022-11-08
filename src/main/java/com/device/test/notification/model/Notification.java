package com.device.test.notification.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;


@Entity
@Table(name = "notification")
@SQLDelete(sql= "update notification set deleted=true where id=?")
@Where(clause = "deleted= false")
@Getter
@Setter
@ToString(includeFieldNames = true)

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String user_id;
    private String app_name;
    private String data;
    @UpdateTimestamp
    @Column(name = "read_at", updatable = true)
    private Date readAt;
    @UpdateTimestamp
    @Column(name="deleted_at", updatable = false)
    private Date deletedAt;
    private String type;
    private String additional_data;

    private Boolean deleted = false;
}

