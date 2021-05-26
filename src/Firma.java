
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.FileMech;
import widok.View;
import kontroler.Contr;
import model.Dyrektor;
import model.Handlowiec;
import model.Pracownik;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakub
 */
public class Firma {
    
    public static boolean checkPesel(String pesel) {
        if (pesel.length()==11)return true;
        else return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        FileMech z = new FileMech();
        View v = new View();
        Contr ctrl = new Contr(z, v);
        
        while (true) {
      System.out.println("MENU");
      System.out.println("    1. Lista pracowników");
      System.out.println("    2. Dodaj pracownika");
      System.out.println("    3. Usuń pracownika");
      System.out.println("    4. Kopia zapasowa");
      System.out.println("    5. Wyjdź\n");
      System.out.print("Wybór>");
      int wyb;
      try {
          wyb=s.nextInt();
      }
      catch (InputMismatchException e) {
        System.err.println("Błędny typ argumentu!");
        s.nextLine();
        wyb = 0;
        }
      
      switch (wyb) {
        case 1:
            try{
            int size;
            size = ctrl.getSize();
            if (size == 0){
            System.out.println("Pusta lista\n");
            break;
            }
            for (int i = 0; i < size; i++) {
              System.out.println("1. Lista pracownikow\n");
              ctrl.wyswietl(i);
              System.out.println("\n                        [Pozycja: " + (i + 1) + "/" + size + "]");
              System.out.println("[P]-nastepny");
              System.out.println("[Q]-powrot");
              String znak = s.next();
              if ((znak.charAt(0) == 'q' || znak.charAt(0) == 'Q') && znak.length() == 1) {
                break;
              }
              else if ((znak.charAt(0) == 'P' || znak.charAt(0) == 'p') && znak.length() == 1) {
                continue;
              }
              else{
               throw new InputMismatchException("błędny argument");
              }
            }
            }catch (InputMismatchException e) {
                System.err.println(e);
                s.nextLine();
                break;
            }
            System.out.println("Koniec listy");
            break;
        case 2:
            try{
          System.out.println("2. Dodaj pracownika\n");
          System.out.print("[D]yrektor/[H]andlowiec:    ");
            String t = s.next();
            if (t.length() != 1) {
              throw new InputMismatchException("błędny argument");
            }
            if ("d".equals(t) || "D".equals(t)) {
              System.out.println("\n---------------------------------------");
              System.out.print("Identyfikator PESEL       :   ");
              String pesel = s.next();
              
              if (checkPesel(pesel)==false){
                throw new InputMismatchException("błędny pesel");
              }
              Long.parseLong(pesel);
              int a = ctrl.compare(pesel);
              if (a > 0) {
                System.err.println("Pracownik o podanym PESEL juz istnieje\n");
                break;
              } 
              System.out.print("Imie                      :   ");
              String imie = s.next();
              System.out.print("Nazwisko                  :   ");
              String nazwisko = s.next();
              System.out.print("Wynagrodzenie (zl)        :   ");
              int wynagrodzenie = s.nextInt();
              System.out.print("Telefon sluzbowy numer    :   ");
              String telefon = s.next();
              System.out.print("Dodatek sluzbowy (zl)     :   ");
              int dodatek = s.nextInt();
              System.out.print("Karta sluzbowa numer      :   ");
              String karta = s.next();
              System.out.print("Limit kosztow/miesiac (zl):   ");
              int limit = s.nextInt();
              System.out.println("---------------------------------------");
              System.out.println("[P]-potwierdź");
              System.out.println("[Q]-porzuc");
              t = s.next();
              if ((t.charAt(0) == 'P' || t.charAt(0) == 'p') && t.length() == 1) {
                Dyrektor nowy = new Dyrektor(pesel, imie, nazwisko, wynagrodzenie, telefon, dodatek,
                        karta, limit);
                ctrl.DodajPracownika((Pracownik)nowy);
                break;
              } 
              if ((t.charAt(0) == 'Q' || t.charAt(0) == 'q') && t.length() == 1) {
                break;
              }
              else{
                throw new InputMismatchException("błędny argument");
              }
            } 
            
            if ("h".equals(t) || "H".equals(t)) {
              System.out.println("\n---------------------------------------");
              System.out.print("Identyfikator PESEL       :   ");
              String pesel = s.next();
              
              if (checkPesel(pesel)==false){
                throw new InputMismatchException("błędny argument");
              }
              Long.parseLong(pesel);
              int a = ctrl.compare(pesel);
              if (a > 0 ) {
                System.err.println("Pracownik o podanym PESEL juz istnieje\n");
                break;
              }
              System.out.print("Imie                      :   ");
              String imie = s.next();
              System.out.print("Nazwisko                  :   ");
              String nazwisko = s.next();
              System.out.print("Wynagrodzenie (zl)        :   ");
              int wynagrodzenie = s.nextInt();
              System.out.print("Telefon sluzbowy numer    :   ");
              String telefon = s.next();
              System.out.print("Prowizja (%)              :   ");
              int prowizja = s.nextInt();
              System.out.print("Limit prowizji/miesiac(zl):   ");
              int limit = s.nextInt();
              System.out.println("---------------------------------------");
              System.out.println("[P]-potwierdź");
              System.out.println("[Q]-porzuć");
              t=s.next();
              if ((t.charAt(0) == 'P' || t.charAt(0) == 'p') && t.length()==1) {
                Handlowiec nowy = new Handlowiec(pesel, imie, nazwisko, wynagrodzenie, telefon, prowizja, limit);
                ctrl.DodajPracownika((Pracownik)nowy);
                break;
              } 
              else if (t.charAt(0) == 'Q' || t.charAt(0) == 'q') {
                break;
              }
              else{
                 throw new InputMismatchException("błędny argument");
              }
            }
            else {
                throw new InputMismatchException("błędny argument");
            }
            }
            catch (InputMismatchException e) {
            System.err.println(e);
            s.nextLine();
            break;
            }
        case 3:
          try {
            System.out.println("3. Usun pracownika\n");
            System.out.print("Podaj identyfikator PESEL       :   ");
            String p = s.next();
            if (checkPesel(p)==false){
              throw new InputMismatchException("Błędny pesel"); 
            }
            Long.parseLong(p);
            int a = ctrl.compare(p);
            if (a == -1) {
              System.out.println("Nie znaleziono pracownika o takim peselu\n");
              
              break;
            } 
            System.out.println("\n-----------------------------------------");
            ctrl.wyswietl(a);
            System.out.println("-----------------------------------------");
            System.out.println("[P]-potwierdz");
            System.out.println("[Q]-powrot");
            
            String wybor = s.next();
            if ((wybor.charAt(0) == 'q' || wybor.charAt(0) == 'Q') && wybor.length() == 1) {
              break;
            }
            if ((wybor.charAt(0) == 'p' || wybor.charAt(0) == 'P') && wybor.length() == 1) {
             ctrl.delete(a);
            }
            
            
            break;
          } catch (InputMismatchException e) {
            System.err.println(e);
            s.nextLine();
            break;
          }
        case 4:
          System.out.println("4. Kopia zapasowa\n");
          System.out.print("[Z]achowaj/[O]dtworz      :   ");
          
          try {
            String t = s.next();
            char kompresja=t.charAt(0);
            if (t.length() != 1) {
              throw new InputMismatchException("Błędny argument");
            }
            if (t.charAt(0) == 'z' || t.charAt(0) == 'Z') {
              System.out.println("-----------------------------------------");
              System.out.print("Kompresja [G]zip/[Z]ip:   ");
              t = s.next();
              char tmp=t.charAt(0);
              if (t.length() != 1) {
                throw new InputMismatchException("Błędny argument");
              }
              System.out.print("Nazwa pliku           :   ");
              String nazwa = s.next();
              System.out.println("-----------------------------------------");
              System.out.println("[p]-potwierdz");
              System.out.println("[Q]-powrot");
              
              String wybor = s.next();
              if ((wybor.charAt(0) == 'q' || wybor.charAt(0) == 'Q') && wybor.length() == 1) {
                break;
              }
              if ((wybor.charAt(0) == 'p' && wybor.charAt(0) == 'P') && wybor.length() == 1) {
                ctrl.write(nazwa, tmp);
                break;
              }
              
            } 
            
            if (t.charAt(0) == 'o' || t.charAt(0) == 'O') {
              System.out.println("-----------------------------------------");
              System.out.print("Nazwa pliku           :   ");
              String nazwa = s.next();
              System.out.println("-----------------------------------------");
              System.out.println("[p]-potwierdz");
              System.out.println("[Q]-powrot");
              
              String wybor = s.next();
              if ((wybor.charAt(0) == 'q' || wybor.charAt(0) == 'Q') && wybor.length() == 1) {
                continue;
              }
              if ((wybor.charAt(0) == 'p' && wybor.charAt(0) == 'P') || wybor.length() == 1) {
                try {
                ctrl.read(nazwa);
                break;
                } catch (FileNotFoundException e) {
                System.err.println("Podany plik nie istnieje");
                break;
              } 
              }
            } 
          } catch (InputMismatchException e) {
            System.err.println(e);
            s.nextLine();
            continue;
          }
        case 5:
          System.exit(0);
          
        default:
        System.out.println("Błędna opcja");
        }
      
          }
        
        
        
    
 }
}
