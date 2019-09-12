package com.analytics.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SPECIALIZATION")
public class Specialization extends Model implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "RATING")
    private Integer rating;
}
