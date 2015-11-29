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
            String string;
//            println validateInput('C:\\Users\\User\\Desktop\\dslinput.txt')
            if (validateInput('D:\\dslinput.txt')==1){
                string = new File('D:\\dslinput.txt').text
                string = new GroovyShell().evaluate("ResiDsl.make{" + string + "}")
            } else {
                string = "not-ok";
            }
            
            return string; 
    }
    
    public int validateInput(String filename) {
        int val = 1
        def dataList = []
        def parameters = "noResi jne tiki kodeWilayahPenerima kepadaText alamatPenerima telpPenerima kodeWilayahPengirim dariText telpPengirim deskripsi rincianBerat service".split()

        File file = new File( filename )

        if( !file.exists() ) {
          println "File does not exist"
        } else {
          def driveInfo = [:]
          file.eachLine { line ->
            if( line.trim() ) {
              def (key,value) = line.split( ' ' ).collect { it.trim() }
              if (parameters.contains(key)) {
                  // nothing
              } else {
                  val = 0;
              }
            }
            else {
              if( driveInfo ) {
                dataList << driveInfo
                driveInfo = [:]
              }
            }
          }
          return val;
          if( driveInfo ) {
            dataList << driveInfo
          }
        }
    }
}

