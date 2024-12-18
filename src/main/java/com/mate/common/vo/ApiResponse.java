package com.mate.common.vo;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private int status;

	private String statusMessage;

	private Object body;

	private List<String> errors;

	private int errorsCount;

	private int count;

	public ApiResponse() {
		this(HttpStatus.OK);
	}

	public ApiResponse(Object body) {
		this();
		this.setBody(body);
	}

	public ApiResponse(HttpStatus httpStatus) {
		this.status = httpStatus.value();
		this.statusMessage = httpStatus.getReasonPhrase();
	}

	public ApiResponse(HttpStatus httpStatus, Object body) {
		this(httpStatus);
		this.setBody(body);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(HttpStatus httpStatus) {
		this.status = httpStatus.value();
		this.statusMessage = httpStatus.getReasonPhrase();
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
		if (body instanceof List list) {
			this.count = list.size();

		} else if (body instanceof Map map) {
			this.count = map.size();
		} else {
			this.count = 1;
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
		this.errorsCount = errors.size();
 	}

	public int getErrorsCount() {
		return errorsCount;
	}

	public void setErrorsCount(int errorsCount) {
		this.errorsCount = errorsCount;
	}

}
