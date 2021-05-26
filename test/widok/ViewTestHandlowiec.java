/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widok;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author Jakub
 */
public class ViewTestHandlowiec {
    
    public ViewTestHandlowiec() {
    }
   

    /**
     * Test of printHandlowiec method, of class View.
     */
    @org.junit.Test
    public void testPrintHandlowiec() {
        
        String pesel = "11";
        String imie = "ti";
        String nazwisko = "tn";
        String stanowisko = "ts";
        int wynagrodzenie = 100;
        String telefon = "234";
        int prowizja = 100;
        int limitp = 20;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String str = outContent.toString();
        System.out.print(str);
        View instance = new View();
        instance.printHandlowiec(pesel, imie, nazwisko, stanowisko, wynagrodzenie, telefon, prowizja, limitp);
        String expectedOutput=(  
        "Pesel                       :   "+pesel+"\n"+
        "Imię                        :   "+imie+"\n"+
        "Nazwisko                    :   "+nazwisko+"\n"+
        "Stanowisko                  :   "+stanowisko+"\n"+
        "Wynagrodzenie (zł)          :   "+wynagrodzenie+"\n"+
        "Telefon służbowy numer      :   "+telefon+"\n"+
        "Prowizja (%)                :   "+prowizja+"\n"+
        "Limit prowizji/miesiąc (zł) :   "+limitp+"\n");
        assertEquals(expectedOutput, outContent.toString());
        
        
        

    }
    
    
}
