
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakub
 * parameterized test for pesel
 */
@RunWith(Parameterized.class)
public class PeselTest {
    private boolean ret;
    private String value;
    private Firma test;
    
    public PeselTest(String value, boolean ret){
   
    this.value=value;
    this.ret=ret;
    }
    @Before
    public void Initialize(){
    test=new Firma();
    }
    @Parameterized.Parameters
    public static Collection input(){
    return Arrays.asList(new Object[][] {{"12345678909",true}, {"11111111111",true}, {"07864578643",true}, {"06783547853",true}, {"85490755386",true}, {"45497346840",true},
        {"123456",false}, {"8675432908711",false}, {"",false}, {"12345678",false}});
    }
    @org.junit.Test
    public void TestPeselTest(){
    System.out.println("Pesel check return value expected: "+ ret +" || Real: "+test.checkPesel(value));
    assertEquals(ret,test.checkPesel(value));
    }
}
