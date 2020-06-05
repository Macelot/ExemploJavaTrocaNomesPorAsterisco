/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.mavenproject1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class NewMain {
     ArrayList<String> names;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name = "Hello Christopher, are you Mary! and Paul. playing football on Friday?";
        Operacoes o = new Operacoes();
        String r=o.hello(name);
        System.out.println("Source "+name);
        System.out.println("Destin "+r);
    }
  
}
