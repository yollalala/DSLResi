
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atia
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputHandler inputhandler = new InputHandler();
        String retval = inputhandler.bacaFile();
        if (retval.equals("err")) {
            System.out.println("Silakan cek inputan Anda lagi");
        } else {
            String output = "<!DOCTYPE html>\n" + retval;
            // write file output.html
            tulisFile(output);
            System.out.println("output berhasil!");
        }
    }
    
    public static void tulisFile(String content) throws IOException {
        //write file
        File file = new File("C:\\Users\\User\\Desktop\\output.html");

        // if file doesnt exists, then create it
        if (!file.exists()) {
                file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
        }
    }
}
