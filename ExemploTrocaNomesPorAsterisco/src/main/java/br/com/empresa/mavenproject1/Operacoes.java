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
public class Operacoes {
    ArrayList<String> names;
    
    public ArrayList<String> loadNames(){
        names=new ArrayList<>();
        try {
            FileReader fr;
            //fr = new FileReader("names.csv");
            fr = new FileReader("C:\\Users\\marce\\Documents\\NetBeansProjects\\mavenproject5\\webApplication002\\names.csv");
            BufferedReader bf;
            bf = new BufferedReader(fr);
            String linha;
            linha=bf.readLine();
            while(linha!=null){
                names.add(linha);
                linha=bf.readLine();
                //System.out.println(linha);
            }
        } catch (Exception e) {
            System.out.println("Error on load file");
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
        }
        return names;
    }
    
    public  String hello(String txt) {
        String txtClean="";
        names=loadNames();
        //split
        String[] post=txt.split(" ");
        String[] postClean=new String[post.length];
        String a="";
        for (int i = 0; i < post.length; i++) {
            a+=post[i]+" ";
        }
        
        for (int i = 0; i < post.length; i++) {
            //remove . , ! ?
            postClean[i]=clean(post[i]);
            for (int j = 0; j < names.size(); j++) {
                if(postClean[i].equalsIgnoreCase(names.get(j))){
                    int size=postClean[i].length();
                    String totalHash="";
                    for (int k = 0; k < size; k++) {
                        totalHash+="*";
                    }
                    post[i]=post[i].replace(names.get(j), totalHash);
                }
            }
        }
        
        for (int i = 0; i < postClean.length; i++) {
            //System.out.println("--->"+post[i]);
            txtClean+=post[i]+" ";
        }
        return " " + txtClean + " !";
    }
    
    public String clean(String source){
        String revome=",.!?";
        for (int i = 0; i < revome.length(); i++) {
            if(source.contains(revome.substring(i,(i+1)))){
               source=source.replaceAll(",","");
            }
            if(source.contains(revome.substring(i,(i+1)))){
               source=source.replaceAll("\\.","");
            }
            if(source.contains(revome.substring(i,(i+1)))){
               source=source.replaceAll("!","");
            }
            if(source.contains(revome.substring(i,(i+1)))){
               source=source.replaceAll("\\?","");
            }
        }
        return source;
    }
}
