package com.ubn.service;

import com.ubn.model.RegisterArg;

public interface RegisterArgService {

	void save(RegisterArg arg);

	RegisterArg findByDeviceId(String deviceId);

}