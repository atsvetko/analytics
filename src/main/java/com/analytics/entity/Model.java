package com.analytics.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
}
