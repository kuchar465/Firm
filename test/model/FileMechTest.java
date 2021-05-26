/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import static org.junit.Assert.assertThrows;

/**
 *
 * @author Jakub
 */
public class FileMechTest {
    private String plik;
    private char typ;
    private ArrayList<Pracownik> lista=new ArrayList<>();
    private FileMech test=new FileMech();
   
    
  

    /**
     * Test of read method, of class FileMech.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testRead1() throws Exception {
        plik="test1.zip";
        System.out.println("file : "+ plik +" || expected: exception");
        assertThrows(FileNotFoundException.class, () -> {
      test.read(plik);
    });
    }
    @org.junit.Test
    public void testRead2() throws Exception {
        plik="test2.gzip";
        System.out.println("file : "+ plik +" || expected: exception");
        assertThrows(FileNotFoundException.class, () -> {
      test.read(plik);
    });
    }
    @org.junit.Test
    public void testRead3() throws Exception {
        plik="test3.zip";
        System.out.println("file : "+ plik +" || expected: exception");
        assertThrows(FileNotFoundException.class, () -> {
      test.read(plik);
    });
    }
    
    @org.junit.Test
    public void testWrite1() throws Exception {
        plik="test5";
        typ='h';
        System.out.println("file : "+ plik +"."+typ+" || expected: exception");
        assertThrows(InputMismatchException.class, () -> {
      test.write(plik,typ);
    });
    }
    @org.junit.Test
    public void testWrite2() throws Exception {
        plik="test6";
        typ='j';
        System.out.println("file : "+ plik +"."+typ+" || expected: exception");
        assertThrows(InputMismatchException.class, () -> {
      test.write(plik,typ);
    });
    }
    @org.junit.Test
    public void testWrite3() throws Exception {
        plik="test6";
        typ='5';
        System.out.println("file : "+ plik +"."+typ+" || expected: exception");
        assertThrows(InputMismatchException.class, () -> {
      test.write(plik,typ);
    });
    }
    
    
    
}
