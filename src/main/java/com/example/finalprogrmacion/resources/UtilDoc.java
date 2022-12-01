package com.example.finalprogrmacion.resources;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class UtilDoc {
    public static ArrayList<String> readDoc(String path) throws IOException{
        ArrayList<String> content = new ArrayList();
        FileReader fr = new FileReader(path);
        BufferedReader bfr = new BufferedReader(fr);
        String line = "";
        while ((line = bfr.readLine()) != null){
            content.add(line);
        }
        bfr.close();
        fr.close();
        return content;
    }

    public static void saveDoc(String path, String content, Boolean b) throws IOException{
        FileWriter fw = new FileWriter(path, b);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(content);
        bfw.close();
        fw.close();
    }

}
