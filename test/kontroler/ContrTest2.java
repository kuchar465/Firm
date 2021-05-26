/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import model.Dyrektor;
import model.FileMech;
import model.Handlowiec;
import model.Pracownik;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import widok.View;

/**
 *
 * @author Jakub
 */
public class ContrTest2 {
    private FileMech zapis;
    private View widok;
    private Handlowiec test1;
    private Dyrektor test2; 
    private Contr con;
    private int expected;
    private String pesel;
    
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
  
    @Before
    public void Initialize(){
    widok = new View();
    zapis=new FileMech();
    con=new Contr(zapis, widok);
    pesel= "12345678901";
    test1=new Handlowiec(pesel, imie, nazwisko, wynagrodzenie, telefon, prowizja, limitk);
    con.DodajPracownika((Pracownik)test1);
    pesel= "45648888888";
    test2=new Dyrektor(pesel, imie, nazwisko, wynagrodzenie, telefon, dodatek,
                        karta, limitp);
    con.DodajPracownika((Pracownik)test2);
    }
     
    
    @org.junit.Test
    public void TestDelete1(){
    expected=-1;
    pesel="12345678999";
    System.out.println("deleting 0: ");
    con.delete(0);
    assertEquals(expected,con.compare(pesel));
    }
    @org.junit.Test
    public void TestDelete2(){
    expected=-1;
    pesel="12345678999";
    System.out.println("deleting 1: ");
    con.delete(1);
    assertEquals(expected,con.compare(pesel));
    }
    @org.junit.Test
    public void TestDelete3(){
    pesel="12345678999";
    System.out.println("deleting 3: exception expected");
    assertThrows(IndexOutOfBoundsException.class, () -> {
      con.delete(3);
    });
    }
}
