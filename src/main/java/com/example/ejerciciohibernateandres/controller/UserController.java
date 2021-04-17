//package com.example.ejerciciohibernateandres.controller;
//
//import com.example.ejerciciohibernateandres.dao.UserDAO;
//import com.example.ejerciciohibernateandres.model.User;
//import com.example.ejerciciohibernateandres.service.BillingInfoService;
//import com.example.ejerciciohibernateandres.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    private final UserService userService;
//    private final UserDAO userDAO;
//    private final BillingInfoService billingInfoService;
//    public UserController(UserService userService, UserDAO userDAO, BillingInfoService billingInfoService) {
//        this.userService = userService;
//        this.userDAO = userDAO;
//        this.billingInfoService = billingInfoService;
//    }
//
//    // RECUPERA TODOS USERS
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> findAllUsers() {
//        List<User> resultList = userService.findAll();
//
//        if (resultList.isEmpty()) {
//          return   new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return ResponseEntity.ok().body(resultList);
//        }
//    }
//
//    // RECUPERA UN USER
//    @GetMapping("/user/{id}")
//    public ResponseEntity<Optional<User>> findOne(@PathVariable Long id){
//
//        Optional<User> userNuevo = userService.findOneUser(id);
//
//        if(userNuevo.isPresent()){
//            return ResponseEntity.ok().body(userNuevo);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // FILTRAR POR DNI
//    @GetMapping("/user/dni/{dni}")
//    public ResponseEntity<User> filterByDni(@PathVariable String dni){
//
//        User result = userDAO.findByDni(dni);
//
//        if(result != null){
//            return ResponseEntity.ok().body(result);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // CREAR UN USER
//    @PostMapping("/user")
//    public ResponseEntity<User> createOneUser(@RequestBody User user){
//
//        if(user.getBillingInfo() == null)
//            return null;
//
//        if(user.getBillingInfo().getId() == null){
//            billingInfoService.createBillingInfo(user.getBillingInfo());
//        }
//
//        if(user.getId() != null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }else{
//            return ResponseEntity.ok().body(userService.createUser(user));
//        }
//    }
//
//    // UPDATE USER
//    @PutMapping("/user")
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//        if(user.getId() == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }else{
//            return ResponseEntity.ok().body(userService.updateUser(user));
//        }
//    }
//}
