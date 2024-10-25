package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserById(int id);

    void update(User user, int id);

    void deleteUser(User user);

}
