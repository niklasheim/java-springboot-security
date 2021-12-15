package net.tempest.rimuru.repo;

import java.util.Optional;

import net.tempest.rimuru.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findById(Integer id);
}