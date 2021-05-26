/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.io.FileNotFoundException;
import java.io.IOException;
import model.Dyrektor;
import model.FileMech;
import model.Handlowiec;
import model.Pracownik;
import widok.View;

/**
 *
 * @author Jakub
 */
public class Contr
{
  private FileMech zapis;
  private View widok;
  
  public Contr(FileMech zapis, View widok) {
    this.zapis = zapis;
    this.widok = widok;
  }
  
  public <T extends Pracownik> void DodajPracownika(T obj) { this.zapis.dodaj((Pracownik)obj); }
  public <T extends Pracownik> void wyswietl(int i) {
    if (this.zapis.get(i).getStanowisko().equals("Dyrektor")) {
      Dyrektor d = (Dyrektor)this.zapis.get(i);
      print(d);
    }
    else if (this.zapis.get(i).getStanowisko().equals("Handlowiec")) {
      Handlowiec d = (Handlowiec)this.zapis.get(i);
      print(d);
    } 
  }
  public int getSize() { return this.zapis.getSize(); }
  private void print(Dyrektor obj) { this.widok.printDyrektor(obj.getPesel(),
          obj.getImie(), obj.getNazwisko(), obj.getStanowisko(),
          obj.getWynagrodzenie(), obj.getTelefon(), obj.getDodatek(),
          obj.getKarta(), obj.getLimit()); }
  private void print(Handlowiec obj) { this.widok.printHandlowiec(obj.getPesel(),
          obj.getImie(), obj.getNazwisko(), obj.getStanowisko(),
          obj.getWynagrodzenie(), obj.getTelefon(), obj.getProwizja(),
          obj.getLimit()); }

  
  public int compare(String pesel) {
    for (int i = 0; i < getSize(); i++) {
      if (this.zapis.get(i).getPesel().equals(pesel)) {
        return i;
      }
    } 
    return -1;
  }
  public void delete(int i) { this.zapis.delete(i); }
  public void write(String nazwa, char typ) throws IOException { this.zapis.write(nazwa, typ); }
  public void read(String nazwa) throws IOException, FileNotFoundException, ClassNotFoundException { this.zapis.read(nazwa); }
}
