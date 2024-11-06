package com.mate.common.vo;

public class TopDestinationVO {
    private String cityName;
    private int numberOfTours;
    private int numberOfRequests;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getNumberOfTours() {
        return numberOfTours;
    }

    public void setNumberOfTours(int numberOfTours) {
        this.numberOfTours = numberOfTours;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }
}
