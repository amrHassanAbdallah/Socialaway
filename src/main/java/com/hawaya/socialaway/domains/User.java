package com.hawaya.socialaway.domains;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String info;
    private String email;
    //todo add images
    private String gender;
    private String[] preferences;
    private Date last_seen;
    private Object loc;

    public Object getLoc() {
        return loc;
    }

    public void setLoc(Object loc) {
        this.loc = loc;
    }

    public static class loc {
        private String type;
        private Float[] coordinates;

        public loc( Float[] coordinates) {
            this.type = "Point";
            this.coordinates = coordinates;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Float[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Float[] coordinates) {
            this.coordinates = coordinates;
        }
    }
/*
    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;
*/

    public User(String name, String info, String email, String gender, String[] preferences,loc location) {
        this.name = name;
        this.info = info;
        this.email = email;
        this.gender = gender;
        this.preferences = preferences;
        this.last_seen = new Date();
        this.loc = location;
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

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    public Date getLast_seen() {
        return last_seen;
    }

    public void setLast_seen(Date last_seen) {
        this.last_seen = last_seen;
    }
}
