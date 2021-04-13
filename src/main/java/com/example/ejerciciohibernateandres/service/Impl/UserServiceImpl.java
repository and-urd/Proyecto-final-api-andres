package com.example.ejerciciohibernateandres.service.Impl;

import com.example.ejerciciohibernateandres.model.User;
import com.example.ejerciciohibernateandres.repository.UserRepository;
import com.example.ejerciciohibernateandres.service.BillingInfoService;
import com.example.ejerciciohibernateandres.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    // Inyección del repositorio UserRepository
    private final UserRepository repository;
    private final BillingInfoService billingInfoService;
    public UserServiceImpl(UserRepository repository, BillingInfoService billingInfoService) {
        this.repository = repository;
        this.billingInfoService = billingInfoService;
    }

    @Override
    public User createUser(User user) {
        if(user == null){
            return null;
        }else{
            return repository.save(user);
        }
    }

    @Override
    public User updateUser(User user) {
        if(user == null || user.getBillingInfo() == null)
            return null;

        if(user.getId() != null && user.getBillingInfo().getId() != null ){

            billingInfoService.updateBillingInfo(user.getBillingInfo());
           return repository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findOneUser(Long id) {
        return repository.findById(id);
    }

}
