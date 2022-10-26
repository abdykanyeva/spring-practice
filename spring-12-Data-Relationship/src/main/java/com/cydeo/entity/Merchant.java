package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name =  "merchants")
@NoArgsConstructor
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private BigDecimal commissionRate;
    private String name;
    private Integer payoutDelayCount;
    private BigDecimal transactionFee;

    public Merchant(String code, BigDecimal commissionRate, String name, Integer payoutDelayCount, BigDecimal transactionFee) {
        this.code = code;
        this.commissionRate = commissionRate;
        this.name = name;
        this.payoutDelayCount = payoutDelayCount;
        this.transactionFee = transactionFee;
    }
}
