package org.example.repository;

import org.example.model.Dispatch;
import org.example.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DispatchRepository extends JpaRepository<Dispatch,Long> {
}
