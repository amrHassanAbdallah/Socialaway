package com.hawaya.socialaway.payloads;

import com.hawaya.socialaway.payloads.customvalidator.ValidLocationConstraint;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class QueryUsersRequest {
    @ValidLocationConstraint
    private Float[] location;
    @NotBlank
    private Integer distance;//todo should gave the user the ability to use km or mile

    @Length(min = 0, max = 1000)
    private Integer page;
    @Length(min = 1, max = 100)
    private Integer limit;

    public Float[] getLocation() {
        return location;
    }

    public Integer getDistance() {
        return distance;
    }



    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }
}
