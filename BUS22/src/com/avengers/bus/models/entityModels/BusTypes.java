package com.avengers.bus.models.entityModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_bustypes")
public class BusTypes {
	@Id
	@Column(name = "bsty_id")
	private int bsty_id;
	@Column(name = "bsty_title")
	private String bsty_title;
	@Column(name = "bsty_desc")
	private String bsty_desc;
	@Column(name = "bsty_farefactor")
	private Double bsty_farefactor;

	public int getBsty_id() {
		return bsty_id;
	}

	public void setBsty_id(int bsty_id) {
		this.bsty_id = bsty_id;
	}

	public String getBsty_title() {
		return bsty_title;
	}

	public void setBsty_title(String bsty_title) {
		this.bsty_title = bsty_title;
	}

	public String getBsty_desc() {
		return bsty_desc;
	}

	public void setBsty_desc(String bsty_desc) {
		this.bsty_desc = bsty_desc;
	}

	public Double getBsty_farefactor() {
		return bsty_farefactor;
	}

	public void setBsty_farefactor(Double bsty_farefactor) {
		this.bsty_farefactor = bsty_farefactor;
	}

	@Override
	public String toString() {
		return "BusTypes [bsty_id=" + bsty_id + ", bsty_title=" + bsty_title + ", bsty_desc=" + bsty_desc
				+ ", bsty_farefactor=" + bsty_farefactor + "]";
	}

}
