package com.codeup.facebookclone.repositories;

import com.codeup.facebookclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.isAdmin = true")
    User findByisAdmin(User user);

    @Query("SELECT c FROM User c WHERE c.email = ?1")
    public User findByEmail(String email);
    public User findByResetPasswordToken(String token);
    User findById(long id);

    User findByEmailIgnoreCase(String email);

}
