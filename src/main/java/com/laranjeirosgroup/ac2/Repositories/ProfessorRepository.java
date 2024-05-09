package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
