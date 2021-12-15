package net.tempest.rimuru.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.tempest.rimuru.model.User;
import net.tempest.rimuru.model.Role;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByRole(Role role);
}
