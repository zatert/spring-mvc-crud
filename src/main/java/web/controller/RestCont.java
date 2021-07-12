package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import web.repository.UserRepo;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestCont {
    @Autowired
    private UserService userServ;
    /*---------========================== GET ONE =========================------------------*/
    @GetMapping(value="/get_one/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        return userServ.getUser(id);
    }
    /*---------========================== GET ALL =========================------------------*/
    @GetMapping(value = "/all_users")
    public ResponseEntity<List<User>> getAll(){
        return userServ.getAll();
    }
    /*---------========================== ADD =========================------------------*/
    @PostMapping(value = "/add_user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
       return userServ.saveUser(user);
    }
    /*---------========================== EDIT =========================------------------*/
    @PutMapping (value = "/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        return userServ.updateUser(id, user);
    }

    /*---------========================== DELETE =========================------------------*/
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        return userServ.deleteUser(id);
    }
}
