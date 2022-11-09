package com.cydeo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToMany(mappedBy = "itemList")
    private List<Cart> carts;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
