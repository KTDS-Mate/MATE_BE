package com.mate.common.vo;

public class CitiesVO {

	/**
	 * 도시의 PK
	 */
	private int id;
	/**
	 * 도시 명 (영어)
	 */
	private String name;
	/**
	 * 국가 PK
	 */
	private int countryId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
}
