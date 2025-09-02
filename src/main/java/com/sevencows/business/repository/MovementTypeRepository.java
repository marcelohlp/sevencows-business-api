package com.sevencows.business.repository;

import com.sevencows.business.model.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementTypeRepository extends JpaRepository<MovementType, Long> {
}
