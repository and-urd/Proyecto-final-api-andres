package com.example.ejerciciohibernateandres.controller;

import com.example.ejerciciohibernateandres.dao.BillingInfoDAO;
import com.example.ejerciciohibernateandres.model.BillingInfo;
import com.example.ejerciciohibernateandres.service.BillingInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BillingInfoController {

    private final BillingInfoService billingInfoService;
    private final BillingInfoDAO billingInfoDAO;
    public BillingInfoController(BillingInfoService billingInfoService, BillingInfoDAO billingInfoDAO) {
        this.billingInfoService = billingInfoService;
        this.billingInfoDAO = billingInfoDAO;
    }

    // Recuperar todos los billingInfo
    @GetMapping("/billing-infos")
    public ResponseEntity<List<BillingInfo>> findAllBillingInfos(){
        List<BillingInfo> listResult =  billingInfoService.findAllBillingInfo();
        if(listResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listResult);
        }
    }

    //Recuperar un BillingInfo por id
    @GetMapping("/billing-info/{id}")
    public ResponseEntity<Optional<BillingInfo>> findOneById(@PathVariable Long id){
        Optional<BillingInfo> result = billingInfoService.findOneBillingInfo(id);
        if(result.isPresent()){
            return ResponseEntity.ok().body(result);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un BillingInfo
    @PostMapping("/billing-info")
    public ResponseEntity <BillingInfo> createOneBillingInfo(@RequestBody BillingInfo billingInfo){
        if(billingInfo == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(billingInfoService.createBillingInfo(billingInfo));
        }
    }

    // Update un BillingInfo
    @PutMapping("/billing-info")
    public ResponseEntity <BillingInfo> updateBillingInfo(@RequestBody BillingInfo billingInfo){
        if(billingInfo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(billingInfoService.updateBillingInfo(billingInfo));
        }
    }

    // Filtrado
    @GetMapping("/billing-info/nombre/{producto}")
    public ResponseEntity<List<BillingInfo>> filterByProductName(@PathVariable String producto){

        List<BillingInfo> resultList = billingInfoDAO.findByProductName(producto);
        if(resultList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(resultList);
        }
    }
}
