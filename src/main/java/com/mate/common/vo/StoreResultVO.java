package com.mate.common.vo;

public class StoreResultVO {

	private String originFileName;
	private String obfuscatedFileName;
	
	// Setter 없이 생성자만 만듬 -> 값을 바꾸지 못하게
	public StoreResultVO(String originFileName, String obfuscatedFileName) {
		this.originFileName = originFileName;
		this.obfuscatedFileName = obfuscatedFileName;
	}
	
	public String getOriginFileName() {
		return originFileName;
	}
	
	public String getObfuscatedFileName() {
		return obfuscatedFileName;
	}
	
}
