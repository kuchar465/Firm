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
public final class Handlowiec extends Pracownik {
  private int prowizja;
  private int limitp;
  
  public Handlowiec(String pesel, String imie, String nazwisko, int wynagrodzenie,
          String telefon, int prowizja, int limit) {
    super(pesel, imie, nazwisko, wynagrodzenie, telefon);
    setProwizja(prowizja);
    setLimit(limit);
  }
  public int getProwizja() { return this.prowizja; }
  public void setProwizja(int prowizja) { this.prowizja=prowizja; }
  @Override
  public int getLimit() { return this.limitp; }
  @Override
  public String getStanowisko() { return "Handlowiec"; }
  @Override
  public void setLimit(int limit) {this.limitp=limit;}
}

