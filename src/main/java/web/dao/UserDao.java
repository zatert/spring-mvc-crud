package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> all();
    void addUser(User user);
    void delete(Integer id);
    void edit(User u);
    User getOne(Integer id);
}
