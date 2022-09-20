/**
 * <p>
 * It is a package for util
 * </p>
 */
package com.ideas2it.employee.util;

import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;  
import java.time.Period;  

/**
 * <p>
 * This class is used to perform date calculation
 * </p>
 */
public class DateUtil {

    /**
     * <p>
     * This method is used to calculate age from birth date 
     * </p>
     *
     * @param employeeDateOfBirth - DateOfBirth of the employee.
     */
    public static int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();  
        if ((null != dateOfBirth) && (null != currentDate)) {
            return Period.between(dateOfBirth, currentDate).getYears();  
        } else {
            return 0;
        }
    }

    /**
     * <p>
     * This methods converts date as per user convenience
     *
     * @return Localdate 
     */
    public static LocalDate convertToDate(String value) throws DateTimeParseException {
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(value, dateFormat);
        } catch(DateTimeParseException exception) {
            throw new DateTimeParseException("Invalid date! ", value, 0);
        }
    }
}