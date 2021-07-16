package web.service;

import web.model.User;

import java.util.List;

public interface UserServ {
    List<User> getAll();
    void add(User u);
    void delete(Integer id);
    void edit (User u);
    User getOne(Integer id);
}
