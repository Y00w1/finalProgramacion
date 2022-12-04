package com.example.finalprogrmacion.resources;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.beans.XMLDecoder;

public class UtilDoc {

    //Persistence in .txt
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

    //Persistence in .xml
    public static Object loadXMLSerializedResource(String path) throws IOException {
        XMLDecoder myXMLDecoder;
        Object XMLObject;

        myXMLDecoder = new XMLDecoder(new FileInputStream(path));
        XMLObject = myXMLDecoder.readObject();
        myXMLDecoder.close();
        return XMLObject;
    }

    public static void saveXMLSerializedResource(String path, Object obj) throws IOException {
        XMLEncoder XMLCodifier;

        XMLCodifier = new XMLEncoder(new FileOutputStream(path));
        XMLCodifier.writeObject(obj);
        XMLCodifier.close();
    }
}
