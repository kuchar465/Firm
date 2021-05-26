/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Jakub
 */
public abstract class Pracownik
  implements Serializable
{
  private String pesel;
  private String imie;
  private String nazwisko;
  private int wynagrodzenie;
  private String telefon;
  
  public Pracownik(String pesel, String imie, String nazwisko, int wynagrodzenie, String telefon) {
    setPesel(pesel);
    setImie(imie);
    setNazwisko(nazwisko);
    setWynagrodzenie(wynagrodzenie);
    setTelefon(telefon);
  }
  
  public String getPesel() { return this.pesel; }
  private void setPesel(String pesel){this.pesel=pesel;}
  public String getImie() { return this.imie; }
  private void setImie(String imie){this.imie=imie;}
  public String getNazwisko() { return this.nazwisko; }
  private void setNazwisko(String nazwisko){this.nazwisko=nazwisko;}
  public int getWynagrodzenie() { return this.wynagrodzenie; }
  private void setWynagrodzenie(int wynagrodzenie){this.wynagrodzenie=wynagrodzenie;}
  public String getTelefon() { return this.telefon; }
  private void setTelefon(String telefon){this.telefon=telefon;}
  
  public abstract String getStanowisko();
  public abstract int getLimit();
  public abstract void setLimit(int limit);
}
