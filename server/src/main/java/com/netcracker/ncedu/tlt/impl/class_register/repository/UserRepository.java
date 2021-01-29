package com.netcracker.ncedu.tlt.impl.class_register.repository;

import java.util.Optional;

import com.netcracker.ncedu.tlt.impl.class_register.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
