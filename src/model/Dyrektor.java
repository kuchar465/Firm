/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jakub
 */
public final class Dyrektor extends Pracownik {
  private int dodatek;
  private String karta;
  private int limit;
  
  public Dyrektor(String pesel, String imie, String nazwisko, int wynagrodzenie,
          String telefon, int dodatek, String karta, int limit) {
    super(pesel, imie, nazwisko, wynagrodzenie, telefon);
    setDodatek(dodatek);
    setKarta(karta);
    setLimit(limit);
  }
  public int getDodatek() { return this.dodatek; }
  public void setDodatek(int dodatek){this.dodatek=dodatek;}
  public String getKarta() { return this.karta; }
  public void setKarta(String karta){this.karta=karta;}
  
  @Override
  public String getStanowisko() { return "Dyrektor"; }
  @Override
  public void setLimit(int limit) {this.limit=limit;}
  @Override
  public int getLimit() {return this.limit;}
}
