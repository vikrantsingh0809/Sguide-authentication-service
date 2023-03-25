package com.sguide.repository;

import com.sguide.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
