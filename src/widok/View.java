/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widok;

/**
 *
 * @author Jakub
 */
public class View {
    public void printDyrektor(String pesel, String imie,String nazwisko,
            String stanowisko, int wynagrodzenie, String telefon,
            int dodatek, String karta, int limitk){
        System.out.println("Pesel                      :   "+pesel);
        System.out.println("Imię                       :   "+imie);
        System.out.println("Nazwisko                   :   "+nazwisko);
        System.out.println("Stanowisko                 :   "+stanowisko);
        System.out.println("Wynagrodzenie (zł)         :   "+wynagrodzenie);
        System.out.println("Telefon służbowy numer     :   "+telefon);
        System.out.println("Dodatek służbowy (zł)      :   "+dodatek);
        System.out.println("Karta służbowa numer       :   "+karta);
        System.out.println("Limit kosztó/miesiąc (zł)  :   "+limitk);
    
    }
    public void printHandlowiec(String pesel, String imie,String nazwisko,
            String stanowisko, int wynagrodzenie, String telefon,
            int prowizja, int limitp){
        System.out.println("Pesel                       :   "+pesel);
        System.out.println("Imię                        :   "+imie);
        System.out.println("Nazwisko                    :   "+nazwisko);
        System.out.println("Stanowisko                  :   "+stanowisko);
        System.out.println("Wynagrodzenie (zł)          :   "+wynagrodzenie);
        System.out.println("Telefon służbowy numer      :   "+telefon);
        System.out.println("Prowizja (%)                :   "+prowizja);
        System.out.println("Limit prowizji/miesiąc (zł) :   "+limitp);
    
    }
   
}
