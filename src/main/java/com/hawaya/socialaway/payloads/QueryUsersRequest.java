package com.hawaya.socialaway.payloads;

import com.hawaya.socialaway.payloads.customvalidator.ValidLocationConstraint;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QueryUsersRequest {
    @ValidLocationConstraint
    private List<Double> location;
    @Range(min = 0, max = 10000)
    @NotNull
    private Integer distance;//todo should gave the user the ability to use km or mile

    @Range(min = 0, max = 1000)
    @NotNull
    private Integer page;
    @Range(min = 1, max = 100)
    @NotNull
    private Integer limit;

    public List<Double> getLocation() {
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
