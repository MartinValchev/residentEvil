package com.task.residentEvil.residentEvil.model;

import com.task.residentEvil.residentEvil.entity.Capitals;
import com.task.residentEvil.residentEvil.entity.Magnitude;
import com.task.residentEvil.residentEvil.entity.Mutation;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VirusBindingModel {

    @NotBlank(message="Name cannot be blank")
    @Size(min=3, max=10,message = "Name must be between 3 and 10 characters")
    private String name;

    @NotBlank(message="Description cannot be blank")
    @Size(min=5, max=100,message = "Description must be between 5 and 100 characters")
    private String description;

    @Size(min=0, max=50,message = "SideEffects must be between 0 and 50 characters")
    private String sideEffects;

    @NotBlank(message="Creator cannot be blank")
    @Pattern(regexp = "([C]|[c])orp")
    private String creator;

    private boolean isDeadly;
    private boolean isCurable;

    @NotNull(message="Mutation cannot be null")
    private Mutation mutation;

    @NotBlank(message= "Turnover Rate cannot be blank")
    @Size(min=0,max = 100,message = "Turnover rate must be between 0 and 100")
    private int turnoverRate;

    @NotBlank(message="Hours Until Turn cannot be blank")
    @Size(min=1,max=12, message = "Hours Until Turn can be between 1 and 12")
    private int hoursUntilTurn;

    private Magnitude magnitude;

    @NotNull(message = "Released On date  cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Released On date must be in future")
    private Date releasedOn;

    private List<Capitals> capitals =new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean getIsDeadly() {
        return isDeadly;
    }

    public void setIsDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean getIsCurable() {
        return isCurable;
    }

    public void setIsCurable(boolean curable) {
        isCurable = curable;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public int getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(int turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public int getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(int hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public Date getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    public List<Capitals> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<Capitals> capitals) {
        this.capitals = capitals;
    }
}
