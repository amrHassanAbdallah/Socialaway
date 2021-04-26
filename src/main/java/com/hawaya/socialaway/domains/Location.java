package com.hawaya.socialaway.domains;

import java.util.List;

public class Location {
    private String type;
    private List<Float> coordinates;

    public Location(List<Float> coordinates) {
        this.type = "Point";
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Float> coordinates) {
        this.coordinates = coordinates;
    }
}
