package com.titowecz.appList.services;

import com.titowecz.appList.models.User;

import java.util.List;
public interface UserService {
  User register(User user);

  List<User> getAll();

  User findByUsername(String username);

  User findById(Long id);

  void delete(Long id);

  boolean isExistUsername(String username);

  boolean isExistEmail(String email);
}
