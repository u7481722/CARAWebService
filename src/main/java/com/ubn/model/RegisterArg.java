package com.ubn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "EMP_GEN", table = "GENERATOR_TABLE", pkColumnName = "pkName", valueColumnName = "pkValue", pkColumnValue = "REGISTER_ARG", initialValue = 1, allocationSize = 1)
public class RegisterArg extends BaseProperty {

	private static final long serialVersionUID = 1L;

	private long id;

	private String deviceId;

	private String userId;

	private String arg;

	private String cert;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EMP_GEN")
	@Column(name = "ID")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "DEVICE_ID", length = 100)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "USER_ID", length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "ARG", length = 10000)
	public String getArg() {
		return this.arg;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}

	@Column(name = "CERT", length = 10000)
	public String getCert() {
		return this.cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

}
