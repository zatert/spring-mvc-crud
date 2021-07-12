package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;

@Controller
//@RequestMapping("/users")
public class MainController {

    @RequestMapping("/users")
    public String pageForRest(){
        return "restform";
    }
//    @Autowired
//    private UserDaoImpl userDao;
//
//
//    //@RequestMapping(value = "/users3", method = RequestMethod.GET)
//    @ResponseBody
//    public String getHello(Model model){
//        return "Hello, i'm controller";
//    }
//
//    @GetMapping(value = "/users")
//    public String allUsers(Model model){
//        //List<User> list = userDao.all();
//        model.addAttribute("list", userDao.all());
//        return "users";
//    }
//
//    @PostMapping(value="/add")
//    public String add(@RequestParam String name, @RequestParam String lastname, @RequestParam Integer age,
//                        Model model){
//    User user = new User(name, lastname, age);
//    userDao.addUser(user);
//    model.addAttribute("list", userDao.all());
//        return "users";
//    }
//
//   // @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @GetMapping("/delete")
//    private String deleteUser(@RequestParam Integer id, Model model){
//        userDao.delete(id);
//        System.out.println("User_Id : ");
//        model.addAttribute("list", userDao.all());
//        return "redirect:/users";
//    }
//      @PostMapping(value="/edit")     //@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)     @PathVariable("id")
////    public String edit(@RequestParam(required=false) Integer id, @RequestParam(required=false) String name,
////                           @RequestParam(required=false) String lastname, @RequestParam(required=false) Integer age, Model model){
////        User user = userDao.getOne(id);
////        if(name != null) {
////            user.setName(name);
////        }
////        if(lastname != null) {
////            user.setLastname(lastname);
////        }
////        if(age != null) {
////            user.setAge(age);
////        }
//          public String edit(User user){
//        userDao.edit(user);
//        //model.addAttribute("list", userDao.all());
//        return "redirect:/users";
//    }
////    @GetMapping("/findOne")
////    @ResponseBody //прочитать
////    public ResponseEntity<User> findOne(Integer id){
////
////        return new ResponseEntity<>(userDao.getOne(id), HttpStatus.OK);
////    }
}
