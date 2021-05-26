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
public class ViewTestDyrektor {
    
    public ViewTestDyrektor() {
    }
    
    

    /**
     * Test of printDyrektor method, of class View.
     */
    @org.junit.Test
    public void testPrintDyrektor() {
        String pesel = "11";
        String imie = "ti";
        String nazwisko = "tn";
        String stanowisko = "ts";
        int wynagrodzenie = 100;
        String telefon = "234";
        int dodatek = 100;
        String karta="222";
        int limitk = 20;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String str = outContent.toString();
        System.out.println(str);
        View instance = new View();
        instance.printDyrektor( pesel, imie, nazwisko,
             stanowisko,  wynagrodzenie,  telefon,
             dodatek,  karta,  limitk);
        String expectedOutput=(  
        "Pesel                       :   "+pesel+"\n"+
        "Imię                        :   "+imie+"\n"+
        "Nazwisko                    :   "+nazwisko+"\n"+
        "Stanowisko                  :   "+stanowisko+"\n"+
        "Wynagrodzenie (zł)          :   "+wynagrodzenie+"\n"+
        "Telefon służbowy numer      :   "+telefon+"\n"+
        "Karta służbowa numer       :   "+karta+"\n"+
        "Limit kosztó/miesiąc (zł)  :   "+limitk+"\n");
        assertEquals(expectedOutput, outContent.toString());

    }
    
}
