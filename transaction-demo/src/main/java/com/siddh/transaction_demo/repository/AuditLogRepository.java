package com.siddh.transaction_demo.repository;

import com.siddh.transaction_demo.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
}
