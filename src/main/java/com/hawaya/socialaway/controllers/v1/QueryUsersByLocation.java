package com.hawaya.socialaway.controllers.v1;

import java.util.ArrayList;
import java.util.List;

public class QueryUsersByLocation {
    private Double lng;
    private Double lat;
    private int distance;
    private String userID;

    private Integer page;
    private Integer limit;
    private ArrayList<String> genders;

    public QueryUsersByLocation(Double lng, Double lat, Integer distance, String userID, Integer page, Integer limit,
                                ArrayList<String> genders) {
        this.lng = lng;
        this.lat = lat;
        this.distance = distance;
        this.userID = userID;
        this.page = page;
        this.limit = limit;
        this.genders = genders;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public int getDistance() {
        return distance;
    }

    public String getUserID() {
        return userID;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }

    public ArrayList<String> getGenders() {
        return genders;
    }
}