package com.cydeo.entity;


import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate created_date;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;


    public Payment(LocalDate created_date, BigDecimal amount, Status paymentStatus) {
        this.created_date = created_date;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
