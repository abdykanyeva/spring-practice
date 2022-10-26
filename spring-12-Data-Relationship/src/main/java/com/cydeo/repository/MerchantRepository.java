package com.cydeo.repository;

import com.cydeo.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface MerchantRepository extends JpaRepository<Merchant, Long> {


}
