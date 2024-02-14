package com.test.test.repository;

import com.test.test.entity.EXPENSE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EXPENSErep extends JpaRepository<EXPENSE,Long> {
}
