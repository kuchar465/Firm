/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.util.Arrays;
import java.util.Collection;
import model.Dyrektor;
import model.FileMech;
import model.Handlowiec;
import model.Pracownik;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import widok.View;

/**
 *
 * @author Jakub
 */
@RunWith(Parameterized.class)
public class ContrTest1 {
    
    private FileMech zapis;
    private View widok;
    private Handlowiec test1;
    private Dyrektor test2; 
    private Contr con;
    private int expected;
    private String pesel;
    
    private String pesel1;
    private String pesel2;
    private String imie = "Jakub";
    private String nazwisko = "Kucharski";
    private String stanowisko = "ts";
    private int wynagrodzenie = 100;
    private String telefon = "234-234-213";
    private int dodatek = 1000;
    private String karta="222-222-222-222";
    private int limitk = 20;
    private int prowizja = 100;
    private int limitp = 20;
    
    public ContrTest1(String pesel, int expected){
    this.pesel=pesel;
    this.expected=expected;
    }
  
    @Before
    public void Initialize(){
    widok = new View();
    zapis=new FileMech();
    con=new Contr(zapis, widok);
    pesel1= "12345678901";
    test1=new Handlowiec(pesel1, imie, nazwisko, wynagrodzenie, telefon, prowizja, limitk);
    con.DodajPracownika((Pracownik)test1);
    pesel2= "45648888888";
    test2=new Dyrektor(pesel2, imie, nazwisko, wynagrodzenie, telefon, dodatek,
                        karta, limitp);
    con.DodajPracownika((Pracownik)test2);
    }
    
    @Parameterized.Parameters
    public static Collection input(){
    return Arrays.asList(new Object[][] {{"12345678901",0}, {"45648888888",1},
        {"07864578643",-1}, {"06783547853",-1}, {"85490755386",-1}, {"45497346840",-1},});
    }
    
   @org.junit.Test
    public void TestCompare(){
    System.out.println("value expected: "+expected+" Real: "+con.compare(pesel));
    assertEquals(expected,con.compare(pesel));
    }
    
    
}
