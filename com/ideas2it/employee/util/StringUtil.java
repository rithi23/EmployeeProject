/**
 * <p>
 *  It is package for util class
 * </p>
 */
package com.ideas2it.employee.util;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * <p>
 * This class is used to perform common validations
 * </p>
 * @author Rithi
 * @since 23/01/2001
 */ 

public class StringUtil {

    /**
     * <p>
     * This method validates whether the input is valid or not valid
     * </p>
     *
     * @param input input is value of the user pattern
     * @param regex regex is the pattern of the input
     */
    public static boolean checkValidInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}