package com.hawaya.socialaway.payloads;

import com.hawaya.socialaway.payloads.customvalidator.ValidLocationConstraint;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


public class CreateUserRequest {
    @NotBlank(message = "name is required")
    @Length(min = 3, max = 30)
    private String name;
    @NotBlank(message = "email is required")
    @Email
    private String email;
    @Length(max = 130)
    private String info;
    @NotBlank(message = "gender is required")
    private String gender;
    private ArrayList<String> preferences;
    @ValidLocationConstraint
    private List<Float> location;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getPreferences() {
        if (this.preferences == null || this.preferences.size() ==0 ){
            this.preferences = new ArrayList<String>();
            if (this.gender.equals("male")){
                this.preferences.add("female");
            }else if(this.gender.equals("female")){
                this.preferences.add("male");
            }

        }
        return preferences;
    }

    public void setPreferences(ArrayList<String> preferences) {
        this.preferences = preferences;
    }

    public List<Float> getLocation() {
        return location;
    }

    public void setLocation(List<Float> location) throws Exception {
        if (location.size() != 2){
            throw new Exception("location only contains lng, lat values");
        }
        this.location = location;
    }
}
