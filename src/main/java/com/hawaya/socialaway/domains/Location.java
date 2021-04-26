package com.hawaya.socialaway.domains;

import java.util.List;

public class Location {
    private String type;
    private List<Double> coordinates;

    public Location(List<Double> coordinates) {
        this.type = "Point";
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
