package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Component
public class UserServImpl implements UserServ{
    @Autowired
    UserDaoImpl userDao;
    @Override
    public List<User> getAll() {
        return userDao.all();
    }

    @Override
    public void add(User u) {
        userDao.addUser(u);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void edit(User u) {
        userDao.edit(u);
    }

    @Override
    public User getOne(Integer id) {
       return userDao.getOne(id);
    }
}
