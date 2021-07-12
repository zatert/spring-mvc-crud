package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import web.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestCont {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDaoImpl userService;
    /*---------========================== GET ONE =========================------------------*/
    @RequestMapping(value="/get_one/{id}", method = RequestMethod.GET)//, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)//
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
//        if(id == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        User user = userService.findById(id);  //  добавим this
//        if(user == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK);

        try{
            return new ResponseEntity<User>(userService.getOne(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

    }
    /*---------========================== GET ALL =========================------------------*/
    @RequestMapping(value = "/all_users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll(){
//        List<User> list = this.userService.findAll();
        List<User> list = new ArrayList<>();
        userService.all().forEach(list::add);
        //userRepo.findAll().forEach(list::add);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    /*---------========================== ADD =========================------------------*/
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //this.userRepo.save(user);
        userService.addUser(user);
        return new  ResponseEntity<>(user, HttpStatus.CREATED);
    }
    /*---------========================== EDIT =========================------------------*/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT) //{id}
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        //User currentUser = userRepo.findById(id).get();
        User currentUser = userService.getOne(id);
        System.out.println(user);
        //System.out.println(username);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        currentUser.setId(id);
        currentUser.setName(user.getName());
        currentUser.setLastname(user.getLastname());
        currentUser.setAge(user.getAge());
        this.userRepo.save(currentUser);
        //System.out.println(user + "   " + currentUser);
        return new  ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    /*---------========================== DELETE =========================------------------*/
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        User user = this.userRepo.findById(id).get();
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //userRepo.deleteById(id);
        userService.delete(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
