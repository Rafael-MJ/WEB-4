package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}
