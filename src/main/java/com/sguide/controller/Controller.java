package com.sguide.controller;

import com.sguide.repository.UserCrudRepository;
import com.sguide.user.User;
import com.sguide.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
public class Controller {

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

  @Autowired
  private UserCrudRepository userCrudRepository;

  @GetMapping("read/user")
  public ResponseEntity<UserInfo> getUserDetails(Principal user){
    String email= user.getName();
    User userDetails = userCrudRepository.findByEmail(email);
    UserInfo userInfo = new UserInfo();

    userInfo.setFirstName(userDetails.getFirstname());
    userInfo.setLastName(userDetails.getLastname());
    userInfo.setRoles(userDetails.getRole());
    userInfo.setUserName(userDetails.getEmail());

    return ResponseEntity.ok(userInfo);
  }

}
