/**
 * <p> 
 * Package for service class 
 * Copyright 2022 - Ideas2it.
 * @since 23/01/2022
 * </p>
 */
package com.ideas2it.employee.service.impl;
 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;  
import java.util.Map;

import org.hibernate.HibernateException;

import com.ideas2it.employee.dao.EmployeeDAO;
import com.ideas2it.employee.dao.impl.EmployeeDAOImpl;
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer;    
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.common.Constants;

/**
 * <p>
 * This class contains business logics methods for trainers and trainees
 * as well as it is used to communicate between Controller as well as DAO
 * </p>
 *
 * @author  Rithikanth
 * @since 23/01/2022
 */
public class EmployeeServiceImpl implements EmployeeService {
 
     private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    /**
     * <p>
     * Method for creating Trainer
     * </p>
     *
     * @param employee - employee is of Trainer type.
     *
     * @return boolean whether the trainer is created or not
     */
    public boolean createTrainer(Trainer trainer) throws HibernateException {
        return employeeDAO.insertTrainer(trainer);
    }

    /**
     * <p>
     * Method for creating Trainee
     * </p>
     *
     * @param employee - employee is of Trainee type.
     *
     * @return returns whether the the trainee is created or not
     */
    public boolean createTrainee(Trainee trainee) throws HibernateException {
        return employeeDAO.insertTrainee(trainee);
    }

    /**
     * <p>
     *  Method for getting the Trainer object
     * </p>
     *
     * @return trainer employee
     */
    public Trainer getTrainer(String id) throws HibernateException {
        return employeeDAO.getTrainer(id);
    }

    /**
     * <p>
     *  Method for getting the Trainee object
     * </p>
     *
     * @return - trainee employee
     */
    public Trainee getTrainee(String id) throws HibernateException {
        return employeeDAO.getTrainee(id);
    }

    /**
     * <p>
     * This method is used for updating trainers it contains three parameters trainer ,
     * menuChoice and the new value . it updates the value in the employeeDAO
     * </p>
     *
     * @param trainer -  trainer is the employee of type trainer
     * @param menuChoice - menuChoice which contains updation menu i.e address or position or previousExperience
     * @param updateValue -  it is new value which to be updated
     *
     * @return boolean - returns whether the trainer is updated or not
     */
    public boolean updateTrainer(String trainerId, int menuChoice, String updateValue) throws HibernateException {
        switch (menuChoice) {
        case 1 :
            return employeeDAO.updateTrainer(trainerId, updateValue, Constants.address);      
        case 2 :
            return employeeDAO.updateTrainer(trainerId, updateValue, Constants.position);   
        default :
             return false;
       } 
    }
    
    /**
     * <p>
     * This method is used for updating trainees it contains three parameters trainer ,
     * menuChoice and the new value . it updates the value in the employeeDAO
     * @param trainee - trainee is the employee of type trainee
     * @param menuChoice -  menuChoice which contains updation menu i.e address or position or previousExperience
     * @param updateValue - it is new value which need to be updated
     * </p>
     *
     * @return boolean - returns whether the trainee is updated or not
     */
     public boolean updateTrainee(String traineeId, int menuChoice, String updateValue) throws HibernateException {
         switch (menuChoice) {
         case 1 :
             return employeeDAO.updateTrainee(traineeId, updateValue, Constants.address);    
         case 2 :
             return employeeDAO.updateTrainee(traineeId, updateValue, Constants.position);             
         default :
             return false;
         }
    }

    /**
     * <p>
     *  Method for updating the Employee By Id
     * </p>
     * @param choice - choice is either Trainer or Trainee
     * @param menuChoice - menuChoice defines the updation menu
     * @param updateValue - updateValue means new value to be updated
     *
     * @return boolean - whether the employee is updated or not
     */   
    public boolean updateEmployeeById(int choice, String id, int menuChoice, String updateValue) throws HibernateException {
         switch (choice) {
         case 1 :
             return updateTrainer(id, menuChoice, updateValue);  
         case 2 :
             return updateTrainee(id, menuChoice, updateValue);  
         default :
             return false;   
         }
     }

    /**
     * <p>
     *  method for deleting the Employee By Id
     * </p>
     * @param choice - choice is either Trainer or Trainee
     * @param employeeId - employeeId is the id of the employee
     *
     * @return boolean - whether the employee is deleted or not
     */
    public boolean deleteEmployeeById(int choice, String employeeId) throws HibernateException {
        switch(choice) {
        case 1 :
             return employeeDAO.deleteTrainer(employeeId);
        case 2 :
             return employeeDAO.deleteTrainee(employeeId);
        default :
             return false;
        }
    } 

    /**
     * <p> 
     * This method shows the list of trainers
     * </p>
     *
     * @return List of returns trainers
     */
    public List<Trainer> showTrainers() throws HibernateException {
        return employeeDAO.showTrainers();
    }

    /**
     * <p>
     * This method shows the list of trainees
     * </p>
     * @return List of returns trainees
     */
    public List<Trainee> showTrainees() throws HibernateException {
        return employeeDAO.showTrainees();
    }
    
    /**
     * <p>
     * This method is for adding trainer to trainees
     * </p>
     * @param trainer - is the trainer employee
     * @param trainee - is the trainee employee
     *
     * @return boolean - whether the trainer is assgigned to trainee or not
     */
    public boolean addTrainerForTrainees(Trainer trainer, Trainee trainee) throws HibernateException {
        return employeeDAO.addTrainerForTrainees(trainer, trainee);
    }
}