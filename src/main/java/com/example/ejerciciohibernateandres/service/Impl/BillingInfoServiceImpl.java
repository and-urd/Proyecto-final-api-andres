//package com.example.ejerciciohibernateandres.service.Impl;
//
//import com.example.ejerciciohibernateandres.model.BillingInfo;
//import com.example.ejerciciohibernateandres.repository.BillingInfoRepository;
//import com.example.ejerciciohibernateandres.service.BillingInfoService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BillingInfoServiceImpl implements BillingInfoService {
//
//    private final BillingInfoRepository repository;
//    public BillingInfoServiceImpl(BillingInfoRepository repository) {
//        this.repository = repository;
//    }
//
//    // CREAR
//    @Override
//    public BillingInfo createBillingInfo(BillingInfo billingInfo) {
//        if(billingInfo == null){
//            return null;
//        }else{
//            return repository.save(billingInfo);
//        }
//    }
//
//    // UPDATE
//    @Override
//    public BillingInfo updateBillingInfo(BillingInfo billingInfo) {
//        if(billingInfo == null){
//            return null;
//        }else{
//            return repository.save(billingInfo);
//        }
//    }
//
//    // FIND ALL
//    @Override
//    public List<BillingInfo> findAllBillingInfo() {
//        return repository.findAll();
//    }
//
//    // FIND ONE
//    @Override
//    public Optional<BillingInfo> findOneBillingInfo(Long id) {
//        return repository.findById(id);
//    }
//
//}
