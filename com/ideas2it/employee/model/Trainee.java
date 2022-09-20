/**
 * <p> 
 * Package for model class 
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.model;
 
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.ideas2it.employee.common.Constants;
import com.ideas2it.employee.model.Employee;

/** 
 * <p>
 * This class contains trainee specific information as well as getters and setters for trainee
 * </p>
 *
 * @author  Rithikanth
 * @since 23/01/2001
 */
@Entity
public class Trainee extends Employee {

    @Column(name = Constants.trainingPeriod)
    private String trainingPeriod;

    @Column(name = Constants.isActive)
    private boolean isActive = true;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Trainer trainer;

    public Trainee(String id, String name, 
	     String bloodGroup, long phoneNumber, String address, String position, float previousExperience, String trainingPeriod, String emailId,LocalDate dateOfBirth, int age) {

        super(id, name, bloodGroup, phoneNumber,
               address, position, previousExperience,
               emailId, dateOfBirth, age);
        this.trainingPeriod = trainingPeriod;
    }

    public Trainee() {}
    
    /**
     * <p>
     * This Method sets the training period for the trainee
     * </p>
     *
     * @param trainingPeriod trainingPeriod is training period for the trainee
     */
    public void setTrainingPeriod(String trainingPeriod) {
        this.trainingPeriod = trainingPeriod;
    }
    
    /**
     * <p>
     * This Method gets the training period for the trainee
     * </p>
     */
    public String getTrainingPeriod() {
        return trainingPeriod;
    }

    /**
     * <p> 
     * This method is used to set the trainer for trainee
     * </p>
     *
     * @param trainerName - is the trainer for trainee
     */
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * <p> 
     * This method is used to get the trainer name for the trainee
     * </p>
     */
    public Trainer getTrainer() {
        return trainer;
    }

    public String toString() {
        return ( "id : " + getId() + "\n" +
                 "name : " + getName() + "\n" +
                 "bloodGroup : " + getBloodGroup() + "\n" +
                 "phoneNumber : " + getPhoneNumber() + "\n" +
                 "address : " + getAddress() + "\n" +
                 "position : " + getPosition() + "\n" +
                 "previousExperience : " + getExperience() + "\n" +
                 "emailId : " + getEmailId() + "\n" +
                 "age : " + getAge() + "\n" +
                 "trainingPeriod : " + getTrainingPeriod() + "\n" );                 
    }
}