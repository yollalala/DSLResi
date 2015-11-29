/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atia
 */
class Test {
    public String bacaFile() {
            String string = new File('D:\\dslinput.txt').text
            string = new GroovyShell().evaluate("ResiDsl.make{" + string + "}")
            
            return string; 
    }
}

