package com.simplebank.Accounts.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter @ToString
public class BaseModel {

   // @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //@CreatedBy
    @Column(updatable = false)
    private String createdBy;

    //@LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    //@LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}