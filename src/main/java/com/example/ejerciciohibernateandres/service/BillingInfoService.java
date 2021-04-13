package com.example.ejerciciohibernateandres.service;

import com.example.ejerciciohibernateandres.model.BillingInfo;

import java.util.List;
import java.util.Optional;

public interface BillingInfoService {

    // Create
    BillingInfo createBillingInfo(BillingInfo billingInfo);

    // Update
    BillingInfo updateBillingInfo(BillingInfo billingInfo);

    // Find all
    List<BillingInfo> findAllBillingInfo();

    // Find one
    Optional<BillingInfo> findOneBillingInfo(Long id);

}
