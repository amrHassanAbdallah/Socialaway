package com.hawaya.socialaway.payloads;

import com.hawaya.socialaway.payloads.customvalidator.ValidLocationConstraint;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


public class CreateUserRequest {
    @NotBlank(message = "name is required")
    @Length(min = 3, max = 30)
    private String name;
    @NotBlank(message = "email is required")
    private String email;
    @Length(max = 130)
    private String info;
    @NotBlank(message = "gender is required")
    private String gender;
    private String[] preferences;
    @ValidLocationConstraint
    private Float[] location;





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

    public String[] getPreferences() {
        if (this.preferences == null || this.preferences.length ==0 ){
            if (this.gender.equals("male")){
               this.preferences = new String[]{"female"};
            }else if(this.gender.equals("female")){
                this.preferences = new String[]{"male"};
            }

        }
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    public Float[] getLocation() {
        return location;
    }

    public void setLocation(Float[] location) throws Exception {
        if (location.length != 2){
            throw new Exception("location only contains lng, lat values");
        }
        this.location = location;
    }
}
