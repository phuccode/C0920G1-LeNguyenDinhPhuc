package vn.codegym.services;

import vn.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
