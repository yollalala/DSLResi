
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
        Test test = new Test();
        String retval = test.bacaFile();
        switch (retval) {
            case "err6":
                System.out.println("unrecognized category");
                break;
            case "err5":
                System.out.println("unrecognized service value");
                break;
            default:
                String output = "<!DOCTYPE html>\n" + test.bacaFile();
                // write file output.html
                tulisFile(output);
                break;
        }
    }
    
    public static void tulisFile(String content) throws IOException {
        //write file
        File file = new File("D:\\output.html");

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
