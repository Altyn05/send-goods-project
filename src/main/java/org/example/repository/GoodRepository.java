package org.example.repository;

import org.example.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface GoodRepository extends JpaRepository<Good,Long> {

    @Query("SELECT g FROM Good g WHERE g.id=:dispatchId")
    List<Good> getGoodsByDispatchId(Long dispatchId);
}
