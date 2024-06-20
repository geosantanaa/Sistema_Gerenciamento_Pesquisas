package br.com.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	boolean existsByEmail(String email);

	Optional<Admin> findByEmail(String email);

}
