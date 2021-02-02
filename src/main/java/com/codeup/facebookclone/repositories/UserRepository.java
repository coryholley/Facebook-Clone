package com.codeup.facebookclone.repositories;

import com.codeup.facebookclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
