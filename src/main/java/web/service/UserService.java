package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDaoImpl userDao;
    /*---------========================== GET ONE =========================------------------*/
    public ResponseEntity<User> getUser(Integer id) {
        try{
            return ResponseEntity.ok().body(userDao.getOne(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    /*---------========================== GET ALL =========================------------------*/
    public ResponseEntity<List<User>> getAll(){
        List<User> list = new ArrayList<>();
        userDao.all().forEach(list::add);
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(list);
    }
    /*---------========================== ADD =========================------------------*/
    public ResponseEntity<User> saveUser(User user){
        if(user == null){
            return ResponseEntity.badRequest().build();
        }
        userDao.addUser(user);
        return ResponseEntity.ok().body(user); //<>(user, HttpStatus.CREATED);
    }
    /*---------========================== EDIT =========================------------------*/
    public ResponseEntity<User> updateUser(Integer id, User user){
        User currentUser = userDao.getOne(id);
        if(user == null){
            return ResponseEntity.badRequest().build();
        }
        currentUser.setId(id);
        currentUser.setName(user.getName());
        currentUser.setLastname(user.getLastname());
        currentUser.setAge(user.getAge());
        userDao.edit(currentUser);
        return ResponseEntity.ok().body(currentUser);
    }
    /*---------========================== DELETE =========================------------------*/
    public ResponseEntity<User> deleteUser(Integer id){
        User user = userDao.getOne(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        userDao.delete(id);
        return ResponseEntity.noContent().build();
    }
}
