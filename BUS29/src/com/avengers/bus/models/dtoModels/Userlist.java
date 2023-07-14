package com.avengers.bus.models.dtoModels;

import java.util.ArrayList;
import java.util.List;

public class Userlist {
	public List<Email> getuser() {
		List<Email> list = new ArrayList<>();
		Email e1 = new Email("vamsimacharla143@gmail.com", "v123");
		Email e2 = new Email("md116imran@gmail.com", "m123");
		Email e3 = new Email("rabinkr2265@gmail.com", "r123");
		list.add(e1);
		list.add(e2);
		list.add(e3);
		return list;
	}
}
