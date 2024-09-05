package com.edapt.app.repository;

import com.edapt.app.entity.Edapt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdaptRepository extends JpaRepository<Edapt, Long> {
}
