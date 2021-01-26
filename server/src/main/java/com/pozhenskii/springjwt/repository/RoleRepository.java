package com.pozhenskii.springjwt.repository;

import java.util.Optional;

import com.pozhenskii.springjwt.models.ERole;
import com.pozhenskii.springjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
