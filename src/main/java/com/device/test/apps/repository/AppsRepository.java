package com.device.test.apps.repository;

import com.device.test.apps.model.Apps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppsRepository extends JpaRepository<Apps, Integer> {
}
