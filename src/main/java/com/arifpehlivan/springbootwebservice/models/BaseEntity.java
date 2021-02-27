package com.arifpehlivan.springbootwebservice.models;

import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * BaseEntity class for entities
 */
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;

    @Column(name = "modified_at")
    protected Instant modifiedAt;

    @Version
    protected Long version;

}
