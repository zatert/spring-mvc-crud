package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import web.repository.UserRepo;
import web.service.UserServImpl;
import web.service.UserService;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class MainController {
    @Autowired
    private UserServImpl userDao;
//    @Autowired
//    private UserRepo userRepo;
//    @RequestMapping("/users")
//    public String pageForRest(){
//        return "restform";
//    }
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
    @GetMapping(value = "/users")
    public String allUsers(Model model){
        List<User> list = userDao.getAll();
        model.addAttribute("list", list);
        //return "redirect:/users";
        return "users";
    }

    @GetMapping("/newUserForm")
    public String newUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userDao.add(user);
        //userRepo.save(user);
        return "redirect:/users";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userDao.edit(user);
        //userRepo.save(user);
        return "redirect:/users";
    }
    @GetMapping("/formForUpdate")
    public String formForUpdate(@RequestParam Integer id, Model model){ //@PathVariable(value = "id")
//        User user = userRepo.findById(id).get();
        User user = userDao.getOne(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer id){
//        userRepo.deleteById(id);
        userDao.delete(id);
        return "redirect:/users";
    }
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
