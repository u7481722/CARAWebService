package com.ubn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ubn.model.RegisterArg;

public interface RegisterArgRepository  extends JpaRepository<RegisterArg, Long>{

	RegisterArg findByDeviceId(String paramString);
}
