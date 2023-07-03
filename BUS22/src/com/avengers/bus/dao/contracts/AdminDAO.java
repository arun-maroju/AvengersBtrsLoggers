package com.avengers.bus.dao.contracts;

import com.avengers.bus.models.entityModels.Admin;

public interface AdminDAO {

	public Admin findByUserId(String user_name);
}
