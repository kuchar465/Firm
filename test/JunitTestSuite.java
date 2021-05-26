/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakub
 */
import kontroler.ContrTest1;
import kontroler.ContrTest2;
import model.FileMechTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   PeselTest.class,
   FileMechTest.class,
   ContrTest1.class,
   ContrTest2.class
})

public class JunitTestSuite {   
}  
