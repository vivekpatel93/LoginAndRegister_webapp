package com.Vivek.LoginAndRegister_app.repository;

import com.Vivek.LoginAndRegister_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
