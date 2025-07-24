package com.example.userauthenticationservice.repositories;

import com.example.userauthenticationservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
}
