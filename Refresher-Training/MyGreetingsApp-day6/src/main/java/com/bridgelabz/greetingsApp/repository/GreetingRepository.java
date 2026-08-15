package com.bridgelabz.greetingsApp.repository;

import com.bridgelabz.greetingsApp.GreetingsApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingsApp, Long> {
    
}
