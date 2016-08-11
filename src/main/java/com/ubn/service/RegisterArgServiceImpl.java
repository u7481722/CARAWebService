package com.ubn.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ubn.model.RegisterArg;
import com.ubn.repository.RegisterArgRepository;

@Service
public class RegisterArgServiceImpl implements RegisterArgService {
	
	@Resource
	RegisterArgRepository registerArgRepository;

	@Override
	public void save(RegisterArg arg) {
		registerArgRepository.save(arg);
	}

	@Override
	public RegisterArg findByDeviceId(String deviceId) {
		return registerArgRepository.findByDeviceId(deviceId);
	}

}
