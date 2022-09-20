/**
 * <p> 
 * Package for dao class 
 * Copyright 2022 - ideas2it.
 * </p>
 */
package com.ideas2it.employee.dao;

import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employee.model.Employee; 
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer; 

/**
 * <p>
 * This EmployeeDAO interface which is used to store trainer and trainee details in abstact  
 * and it acts as the database for our project
 *
 * @author RithiKanth
 * @since 2022
 * </p>
 */
public interface EmployeeDAO {

    /**
     * <p>
     * This abstract method is used for insert Trainers in the List
     * </p>
     *
     * @param trainer trainer contains trainer employee details
     *
     * @return boolean - whether the trainer is inserted or not
     */   
    public boolean insertTrainer(Trainer trainer) throws HibernateException;

    /**
     * <p>
     * This abstract method is used for insert Trainees in the List
     * </p>
     *
     * @param trainee trainee contains trainee employee details
     *
     * @return boolean - whether the trainee is inserted or not
     */
    public boolean insertTrainee(Trainee trainee) throws HibernateException;
    
   /**
     * <p>
     * This abstract method is used to get the specific trainer.
     * </p>
     *
     * @param id
     *
     * @return trainer employee
     */
    public Trainer getTrainer(String id)throws HibernateException;

    /**
     * <p>
     * This abstract method is used to get the specific trainee.
     * </p>
     * @paramid id is the employeeid
     *
     * @return trainee employee
     */
    public Trainee getTrainee(String id) throws HibernateException;
    
    /**
     * <p>
     * This method is used for update Address for trainer 
     * </p>
     *
     * @param trainerId - is the id of trainer 
     * @updateValue updateValue is the new value for trainer
     * @column - column of the Trainer class entity
     */ 
    public boolean updateTrainer(String trainerId, String updateValue, String column) throws HibernateException ;
    
    /**
     * <p>
     * This method is used for update Address for trainee 
     * </p>
     *
     * @param traineeId - is the id of trainee 
     * @updateValue updateValue is the new value for trainee
     * @column - column of the Trainee class entity
     */ 
    public boolean updateTrainee(String traineeId, String updateValue, String column) throws HibernateException;

    /**
     * <p>
     * This abstract method is used to delete the specific trainer.
     * </p>
     *
     * @paramemployeeId id is the employeeid
     */
    public boolean deleteTrainer(String employeeId) throws HibernateException;

    /**
     * <p>
     * This abstract method is used to delete the specific trainee.
     * </p>
     *
     * @paramemployeeId id is the employeeid
     */
    public boolean deleteTrainee(String employeeId) throws HibernateException;

    /**
     * <p> 
     * This method shows the list of trainers
     * </p>
     */
    public List<Trainer> showTrainers() throws HibernateException;

    /**
     * <p>
     * This method shows the list of trainees
     * </p>
     */
    public List<Trainee> showTrainees() throws HibernateException;

    /**
     * <p>
     * This method is for adding trainer to trainees
     * </p>
     * @param trainer - is the trainer employee
     * @param trainee - is the trainee employee
     */
    public boolean addTrainerForTrainees(Trainer trainer,Trainee trainee) throws HibernateException;
}