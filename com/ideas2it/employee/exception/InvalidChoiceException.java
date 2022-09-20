/**
 * <p>
 * This is the package for exception 
 */
package com.ideas2it.employee.exception;

import java.lang.Exception;

/**
 * <p>
 * This class handles the custom exceptions whether the choice is valid or not
 * </p>
 * @author Rithikanth
 * @since 23/01/2022
 */
public class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        super(message);
    }
}
    