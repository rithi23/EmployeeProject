/**
 * <p> 
 * Package for service class 
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.service;

import org.hibernate.HibernateException;

import java.util.ArrayList; 
import java.util.List;
 
import com.ideas2it.employee.dao.impl.EmployeeDAOImpl;
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer; 

/**
 * <p>
 * This interface class contains business logics methods without body for trainers and trainees
 * as well as it is used to communicate between Controller as well as DAO
 * </p>
 *
 * @author RithiKanth 
 * @since 23/01/2022
 */
public interface EmployeeService {

    /**
     * <p>
     * Abstract Method for creating Trainer
     * </p>
     *
     * @param trainer - trainer is of Trainer employee type.
     *
     * @return boolean whether the trainer is created or not
     */
    public boolean createTrainer(Trainer trainer) throws HibernateException;
 
    /**
     * <p>
     * Abstract Method for creating Trainee
     * </p>
     *
     * @param trainee - trainee is of Trainee employee type.
     *
     * @return returns whether the the trainee is created or not
     */                  
    public boolean createTrainee(Trainee trainee) throws HibernateException; 

    /**
     * <p>
     * Abstract Method for getting the Trainer object
     * </p>
     * @return trainer employee
     */
    public Trainer getTrainer(String id) throws HibernateException;

    /**
     * <p>
     * Abstract Method for getting the Trainee object
     * </p>
     *
     * @return - trainee employee
     */
    public Trainee getTrainee(String id) throws HibernateException;

    /**
     * <p>
     * This method is used for updating trainers it contains three parameters trainer ,
     * menuChoice and the new value . it updates the value in the employeeDAO
     * </p>
     *
     * @param trainer - trainer is the employee of type trainer
     * @param menuChoice - menuChoice which contains updation menu i.e address or position or previousExperience
     * @param updateValue - it is new value which to be updated
     *
     * @return boolean - returns whether the trainer is updated or not
     */
    public boolean updateTrainer(String trainerId, int menuChoice, String updateValue) throws HibernateException;
    
    /**
     * <p>
     * This method is used for updating trainees it contains three parameters trainer ,
     * menuChoice and the new value . it updates the value in the employeeDAO
     * </p>
     *
     * @param trainee  - trainee is the employee of type trainee
     * @param menuChoice - menuChoice which contains updation menu i.e address or position or previousExperience
     * @param updateValue -  is new value which need to be updated
     *
     * @return boolean - returns whether the trainee is updated or not
     */
    public boolean updateTrainee(String traineeId, int menuChoice,String updateValue) throws HibernateException;

    /**
     * <p>
     *  Abstract Method for updating the Employee By Id
     * </p>
     *
     * @param choice - choice is either Trainer or Trainee
     * @param menuChoice - menuChoice defines the updation menu
     * @param updateValue - updateValue means new value to be updated
     *
     * @return boolean - whether the employee is updated or not
     */
    public boolean updateEmployeeById(int choice, String id, int menuChoice, String updateValue) throws HibernateException;

    /**
     * <p>
     *  Abstract method for deleting the Employee By Id
     * </p>
     *
     * @param choice - choice is either Trainer or Trainee
     * @param employeeId - employeeId is the id of the employee
     *
     * @return boolean - whether the employee is deleted or not
     */
    public boolean deleteEmployeeById(int choice, String employeeId) throws HibernateException;

    /**
     * <p> 
     * This method shows the list of trainers
     * </p>
     *
     * @return List of returns trainers
     */
    public List<Trainer> showTrainers() throws HibernateException;
  
    /**
     * <p>
     * This method shows the list of trainees
     * </p>
     * @return List of returns trainees
     */
    public List<Trainee> showTrainees() throws HibernateException;
  
    /**
     * <p>
     * This method is for adding trainer to trainees
     * </p>
     * @param trainer - is the trainer employee
     * @param trainee - is the trainee employee
     *
     * @return boolean - whether the trainer is assgigned to trainee or not
     */
    public boolean addTrainerForTrainees(Trainer trainer, Trainee trainee) throws HibernateException;
}

    