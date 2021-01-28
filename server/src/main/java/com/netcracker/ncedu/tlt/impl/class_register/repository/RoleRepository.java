package com.netcracker.ncedu.tlt.impl.class_register.repository;

import java.util.Optional;

import com.netcracker.ncedu.tlt.impl.class_register.models.ERole;
import com.netcracker.ncedu.tlt.impl.class_register.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
