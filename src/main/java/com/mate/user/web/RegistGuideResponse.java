package com.mate.user.web;

import java.util.List;

public class RegistGuideResponse {
	
	private boolean success;
    
	private List<String> generatedLcnIds;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public List<String> getGeneratedLcnIds() {
        return generatedLcnIds;
    }

    public void setGeneratedLcnIds(List<String> generatedLcnIds) {
        this.generatedLcnIds = generatedLcnIds;
    }
    
    
}
