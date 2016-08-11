package com.ubn.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ubn.dto.DeviceDTO;
import com.ubn.dto.PublickeyDTO;
import com.ubn.model.RegisterArg;
import com.ubn.service.RegisterArgService;

import net.ubn.td.cara.DeviceRegisterResult;
import net.ubn.td.cara.GetArg;

@RestController
public class DeviceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);
	@Resource
	RegisterArgService registerArgService;

	@RequestMapping(value = "/registerDevice" , method = RequestMethod.POST)
	public @ResponseBody DeviceDTO registerDevice(@RequestParam String deviceId) {
		DeviceDTO dto = new DeviceDTO();
		LOGGER.debug("CARA registerDevice deviceId=" + deviceId);
		try {
			GetArg arg = new GetArg();
			LOGGER.debug("CARA registerDevice GetArg=" + arg);

			DeviceRegisterResult result = arg.gen(deviceId);
			LOGGER.info("Arg=" + result.getArg());   //p12
			LOGGER.info("Cert=" + result.getCert()); //憑證

			RegisterArg registerArg = registerArgService.findByDeviceId(deviceId);
			if (registerArg == null) {
				registerArg = new RegisterArg();
			}
			registerArg.setArg(result.getArg());
			registerArg.setCert(result.getCert());
			registerArg.setDeviceId(deviceId);
			this.registerArgService.save(registerArg);

			dto.setReturnCode(0);
			dto.setReturnMessage("success");
			dto.setP12(result.getArg());
		} catch (Exception ex) {
			ex.printStackTrace();
			dto.setReturnCode(2);
			dto.setReturnMessage(ex.getMessage());
			LOGGER.error("CARA registerDevice fail=" + ex);
		}
		return dto;
	}

	@RequestMapping(value = "/getPublicKey/{deviceId}", method = RequestMethod.GET)
	@ResponseBody
	public PublickeyDTO getPublicKey(@PathVariable String deviceId) {
		PublickeyDTO dto = new PublickeyDTO();
		try {
			//GetArg arg = new GetArg();
			//DeviceRegisterResult result = arg.gen(deviceId);
			RegisterArg registerArg = registerArgService.findByDeviceId(deviceId);	
			dto.setReturnCode(0);
			dto.setReturnMessage("success");
			dto.setPublickey(registerArg.getCert());
		} catch (Exception ex) {
			ex.printStackTrace();
			dto.setReturnCode(-1);
			dto.setReturnMessage(ex.getMessage());
			LOGGER.error("CARA getPublicKey fail=" + ex);
		}
		return dto;
	}

}
