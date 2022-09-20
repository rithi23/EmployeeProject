/**
 * <p> 
 * Package for dao class 
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ideas2it.employee.common.Constants;
import com.ideas2it.employee.dao.EmployeeDAO;
import com.ideas2it.employee.model.Employee; 
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer;
import com.ideas2it.employee.util.ConnectionUtil;


/**
 * <p>
 * This EmployeeDAO class which is used to store trainer and trainee details   
 * and it acts as the API for our project.
 * </p>
 *
 * @author RithiKanth
 * @since 23/01/2022
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String getTrainerHql = "FROM Trainer WHERE employee_id = :id" +
                                                " AND is_active = true"; 
    
    private static final String getTraineeHql = "FROM Trainee WHERE employee_id = :id" +
                                                " AND is_active = true"; 

    private static final String deleteTrainerHql = "UPDATE Trainer SET is_active = false" +
                                                   " WHERE employee_id = :trainerId ";

    private static final String deleteTraineeHql = "UPDATE Trainee SET is_active = 0" +
                                                    " WHERE employee_id = :traineeId "; 

    private static final String showTrainersHql = "FROM Trainer";

    private static final String showTraineesHql = "FROM Trainee WHERE trainer_table_id = NULL ";
    
    /**
     * <p>
     * This method is used for insert Trainers in the List
     * </p>
     *
     * @param trainer - trainer is of trainer Employee
     *
     * @return boolean - whether the trainer is inserted or not
     */
    public boolean insertTrainer(Trainer trainer) throws HibernateException {        
        boolean status = false;
        try {
            Session session = ConnectionUtil.createConnection();
            Transaction transaction =session.beginTransaction();
            session.save(trainer);
            transaction.commit();
            status = true;
       } catch(HibernateException hibernateException) {
           throw new HibernateException(hibernateException.getMessage() + "Cant able to insert trainer");
       } 
       return status;
    }

    /**
     * <p>
     * This method is used for insert Trainees in the List
     * </p>
     *
     * @param trainee - trainee is of trainee employee
     *
     * @return boolean - whether the trainee is inserted or not
     */
     public boolean insertTrainee(Trainee trainee) throws HibernateException {   
         Session session = null; 
         boolean status = false;          
         try {
            session = ConnectionUtil.createConnection();
            Transaction transaction = session.beginTransaction();
            session.save(trainee);
            transaction.commit();
            status = true;
       } catch(HibernateException hibernateException) {
           throw new HibernateException(hibernateException.getMessage() + "Cant able to insert trainee");
       } finally {
           session.close();
       }
       return status;
    }

    /**
     * <p>
     * This method is used to get the specific trainer.
     * </p>
     *
     * @param id - id of the employee
     *
     * @return trainer employee
     */
    public Trainer getTrainer(String id) throws HibernateException {
        Session session = null;   
        Trainer trainer;      
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction(); 
           Query query = session.createQuery(getTrainerHql);
           query.setParameter("id", id);
           trainer = (Trainer)query.uniqueResult();
           transaction.commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to get trainer");
        } finally {
            session.close();
        }
        return trainer;
    } 

    /**
     * <p>
     * This method is used to get the specific trainee.
     * </p>
     *
     * @param id - id of the employee
     *
     * @return trainee employee
     */
    public Trainee getTrainee(String id) throws HibernateException {
        Session session = null;  
        Trainee trainee;   
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction();           
           Query query = session.createQuery(getTraineeHql);
           query.setParameter("id", id);
           trainee = (Trainee)query.uniqueResult();
           session.getTransaction().commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to get trainee");
        } finally {
            session.close();
        }
        return trainee;
    }    
    
    /**
     * @inheritDocs
     */
    public boolean updateTrainer(String trainerId,  String updateValue, String column) throws HibernateException {
        Session session = null; 
        int status;             
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction();
           String updateTrainerHql = "UPDATE Trainer SET " + column + "  = :updateValue" +
                                     " WHERE id = :trainerId AND isActive = true ";
           Query query = session.createQuery(updateTrainerHql);
           query.setParameter("updateValue", updateValue);
           query.setParameter("trainerId", trainerId);
           status = query.executeUpdate();
           session.getTransaction().commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to update trainer");
        } finally {
            session.close();
        }
        return status > 0;
    }
    
    
    /**
     * @inheritDocs
     */
    public boolean updateTrainee(String traineeId,String updateValue, String column) throws HibernateException {
        Session session = null; 
        int status;             
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction();
           String updateTraineeHql = "UPDATE Trainee SET " + column + "  = :updateValue" +
                                     " WHERE employee_id = :traineeId AND is_active = true"; 
           Query query = session.createQuery(updateTraineeHql);
           query.setParameter("updateValue", updateValue);
           query.setParameter("traineeId", traineeId);        
           status = query.executeUpdate();
           transaction.commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to update trainee");
        } finally {
            session.close();
        }
        return (status > 0);
    }
    
    /**
     * <p>
     * This method is used to delete the specific trainer.
     * </p>
     *
     * @param employeeId - id of the employee
     */
    public boolean deleteTrainer(String employeeId) throws HibernateException {
        Session session = null; 
        int status;             
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction();
           Query query = session.createQuery(deleteTrainerHql);
           query.setParameter("trainerId", employeeId);
           status = query.executeUpdate();
           session.getTransaction().commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to delete trainer");
        } finally {
            session.close();
        }
        return (status > 0);
    }
  
    /**
     * <p>
     * This method is used to delete the specific trainee.
     * </p>
     *
     * @param employeeId - id of the employee
     */
    public boolean deleteTrainee(String employeeId) throws HibernateException {
        Session session = null; 
        int status;             
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction(); 
           Query query = session.createQuery(deleteTraineeHql);
           query.setParameter("traineeId", employeeId);
           status = query.executeUpdate();
           session.getTransaction().commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to delete trainer");
        } finally {
            session.close();
        }
        return (status > 0);
    }

    /**
     * @inheritDocs
     */
    public List<Trainer> showTrainers() throws HibernateException {
        List<Trainer> trainers = new ArrayList<Trainer>();
        Session session = null; 
        int status;             
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction();
           Query query = session.createQuery(showTrainersHql);
           trainers = query.list();
           session.getTransaction().commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to show trainers");
        } finally {
            session.close();
        }
        return trainers;
    }    
   
       
    /**
     * @inheritDocs
     */
    public List<Trainee> showTrainees() throws HibernateException {
        List<Trainee> trainees = new ArrayList<Trainee>();
        Session session = null; 
        int status;             
        try {
           session = ConnectionUtil.createConnection();
           Transaction transaction = session.beginTransaction();
           Query query = session.createQuery(showTraineesHql);
           trainees = query.list();
           session.getTransaction().commit();
        } catch(HibernateException hibernateException) {
            throw new HibernateException(hibernateException.getMessage() + "Cant able to show trainees");
        } finally {
            session.close();
        }
        return trainees;
    } 

    /**
     * @inheritDocs
     */
    public boolean addTrainerForTrainees(Trainer trainer,Trainee trainee) throws HibernateException {
        Session session = null; 
        boolean status = false;
        try {
            session = ConnectionUtil.createConnection();
            Transaction transaction = session.beginTransaction();
            trainee.setTrainer(trainer);
            session.update(trainee);
            session.getTransaction().commit();
            status = true;
         } catch (HibernateException hibernateException) {
             hibernateException.printStackTrace();
             throw new HibernateException(hibernateException.getMessage() + "Cant able to assign trainer");
         } finally {
             session.close();  
         }   
         return status;                    
    }
}