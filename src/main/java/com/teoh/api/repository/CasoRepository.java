package com.teoh.api.repository;

import com.teoh.api.model.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, Integer> {
}
