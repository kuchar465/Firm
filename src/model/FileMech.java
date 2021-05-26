/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Jakub
 */
public class FileMech {
     ArrayList<Pracownik> lista = new ArrayList<>();

  public <T extends Pracownik> void dodaj(T obj) { this.lista.add(obj); }
  public int getSize() { return this.lista.size(); }
  public <T extends Pracownik> T get(int i) { return (T)this.lista.get(i); }
  public void delete(int i) { this.lista.remove(i); }

public void write(String plik, char typ) throws FileNotFoundException, IOException {
    if (typ == 'g' || typ == 'G') {
      File file = new File(plik + ".gzip");
      try(FileOutputStream out = new FileOutputStream(file); 
          GZIPOutputStream gzip = new GZIPOutputStream(out); 
          ObjectOutputStream objout = new ObjectOutputStream(gzip)) {
          objout.writeObject(lista);
      }
    }
    else if(typ == 'z' || typ == 'Z'){
        File file = new File(plik);
        try (FileOutputStream out = new FileOutputStream(file);
                ObjectOutputStream objout = new ObjectOutputStream(out);){
            objout.writeObject(lista);
            String zipFileName = file.getName().concat(".zip");
        
            try(FileOutputStream fileout = new FileOutputStream(zipFileName);
                ZipOutputStream zip = new ZipOutputStream(fileout);){
                zip.putNextEntry(new ZipEntry(file.getName()));
                byte[] bytes = Files.readAllBytes(Paths.get(plik, new String[0]));
                zip.write(bytes, 0, bytes.length);
                file.delete();
                }
      }
    }
    else{
        throw new InputMismatchException("błędny argument");
    }
  }

  public void read(String nazwa) throws FileNotFoundException, IOException, ClassNotFoundException {
    if (nazwa.endsWith(".zip")) {
      File cFile = new File(".");
      String filepath = cFile.getAbsolutePath();
      File curDirFile = new File(filepath);
      byte[] buffer = new byte[1024];
      try(ZipInputStream zip = new ZipInputStream(new FileInputStream(nazwa));){
        ZipEntry zipEntry = zip.getNextEntry();
        File newFile = newFile(curDirFile, zipEntry);
            try(FileOutputStream out = new FileOutputStream(newFile);){
                int len;
                while ((len = zip.read(buffer)) > 0) {
                 out.write(buffer, 0, len);
                }
            }
        FileInputStream fileIn = new FileInputStream(newFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        lista = (ArrayList)objectIn.readObject();
        newFile.delete();
      }
    }
    else if (nazwa.endsWith(".gzip")) {
        try(FileInputStream in = new FileInputStream(nazwa);
            GZIPInputStream gzipin = new GZIPInputStream(in);){
                ObjectInputStream objout = new ObjectInputStream(gzipin);
                lista = (ArrayList)objout.readObject();
            }
    } else {
      System.err.println("\nPodano zle rozszerzenie pliku\n");
    } 
  }

    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
    File destFile = new File(destinationDir, zipEntry.getName());
    
    String destDirPath = destinationDir.getCanonicalPath();
    String destFilePath = destFile.getCanonicalPath();
    
    if (!destFilePath.startsWith(destDirPath + File.separator)) {
      throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
    }
    
    return destFile;
  }
}