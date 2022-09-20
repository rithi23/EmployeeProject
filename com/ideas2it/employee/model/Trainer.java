/**
 * <p> 
 * This is the package for model class 
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ideas2it.employee.common.Constants;
import com.ideas2it.employee.model.Employee;


/**
 * <p>
 * Trainer class has trainer specific details as well as 
 * setters and getters for trainers
 * </p>
 * @author Rithikanth
 * @since 23/01/2022
 */
@Entity
public class Trainer extends Employee {

    @Column(name = Constants.project)
    private String project;

    @Column(name = Constants.manager)
    private String manager;

    @Column(name = Constants.isActive)
    private boolean isActive = true;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "trainer")
    private List<Trainee> trainees = new ArrayList<Trainee>();

    public Trainer(String id, String name,
	     String bloodGroup, long phoneNumber, String address, String position, float previousExperience, String project, String manager,String emailId, LocalDate dateOfBirth, int age)  {

         super( id, name, bloodGroup, phoneNumber, address,
              position, previousExperience, emailId, dateOfBirth, age);
         this.project = project;
         this.manager = manager;
    }

    public Trainer () {}

    /**
     * <p>
     * This method sets the project for the trainer
     * </p>
     * @param project project of the trainer
     */
    public void setProject(String project) {
        this.project = project;
    }
    
    /**
     *<p>
     * This method gets the project of the trainer
     * </p>
     */
    public String getProject() {
        return project;
    }
    
    /**
     * <p>
     * This method sets the manager for the trainer
     * </p>
     * @param manager this is manager for the trainer
     */
    public void setManager(String manager) { 
        this.manager = manager;
    }
  
    /**
     * <p>
     * This method gets the manager for the trainer
     * </p>
     */
    public String getManager() {
        return manager;
    }

    /**
     * <p>
     * This method sets the traineee for the trainers
     * </p>
     *
     * @param trainee - trainee is of trainee employee
     */
    public void setTrainees(Trainee traineeId) {
        this.trainees.add(traineeId);
        
    }

    /**
     * <p>
     * This method is used to get the trainee's list
     * </p>
     */     
    public List<Trainee> getTrainees() {
        return trainees;
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
                 "project : " + getProject() + "\n" +
                 "manager : " + getManager() + "\n");
                 
    }
}