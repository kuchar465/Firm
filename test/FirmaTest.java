/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Jakub
 */
public class FirmaTest {
    
    public static void main(String[] args){
        Result result=JUnitCore.runClasses(JunitTestSuite.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
    
    
}
