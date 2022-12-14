package com.cydeo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
public class Cinema extends BaseEntity{

    private String name;
    private String sponsoredName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
}
