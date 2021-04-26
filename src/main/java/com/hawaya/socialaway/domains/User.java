package com.hawaya.socialaway.domains;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CompoundIndex(def = "{'loc':'2dsphere', 'gender':-1,'_id':-1}", name = "users_near_each_others")
@Document(collection = "users")
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String info;
    private String email;
    //todo add images
    private String gender;
    private ArrayList<String> preferences;
    private Date last_seen;
    @GeoSpatialIndexed(name = "geo_index",type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location loc;

    public User(String name, String info, String email, String gender, ArrayList<String> preferences,
                List<Double> coordinates) {
        this.name = name;
        this.info = info;
        this.email = email;
        this.gender = gender;
        this.preferences = preferences;
        this.last_seen = new Date();
        this.loc = new Location(coordinates);
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<String> preferences) {
        this.preferences = preferences;
    }

    public Date getLast_seen() {
        return last_seen;
    }

    public void setLast_seen(Date last_seen) {
        this.last_seen = last_seen;
    }

    public Location getLoc() {
        return loc;
    }

}
