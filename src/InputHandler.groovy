/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atia
 */

class InputHandler {
    // C:\\Users\\User\\Desktop\\
    
    public String bacaFile() {
        // String string
            String string = 'D:\\dslinput.txt'
            int val = validateInput(string)
            if (val==1){
                
                string = new File('D:\\dslinput.txt').text
                string = new GroovyShell().evaluate("ResiDsl.make{" + string + "}")
            }
            else {
                string = "err";
            }
            
            return string; 
    }
    
    public int validateInput(String filename) {
        int val = 1
//        def dataList = []
        def parameters = "biayakirim biayatambahan jumlahtitipan jne tiki kwpenerima kepada alamatpenerima alamatpengirim telppenerima kwpengirim dari telppengirim deskripsi berat service tipebarang".split()

        File file = new File( filename )
        String stringfile = new File('D:\\dslinput.txt').text

        if( !file.exists() ) {
          println "File does not exist"
        } else {
          def driveInfo = [:]
          
        // loop
        if (stringfile.contains('tiki')) {
            file.eachLine { line ->
                def (key,value) = line.split( ' ' ).collect { it.trim() }
                if (parameters.contains(key)) {
                    TikiHandler.addCategory(key)
                    if (key == "service") {
                        if (TikiHandler.checkService(value)!=1) {
                            val = TikiHandler.checkService(value)
                        }
                    }
                } else {
                    val = 0
                }
            }
            if (TikiHandler.categoryCompleteness()==0) {
                val = 0
            }
        } else { //jne
            file.eachLine { line ->
                def (key,value) = line.split( ' ' ).collect { it.trim() }
                if (parameters.contains(key)) {
                    JneHandler.addCategory(key)
                    if (key == "service") {
                        if (JneHandler.checkService(value)!=1) {
                            val = JneHandler.checkService(value)
                        }
                    } else if (key == "tipebarang") {
                        if (JneHandler.checkTipeBarang(value)!=1) {
                            val = JneHandler.checkTipeBarang(value)
                        }
                    }
                } else {
                    val = 0
                }
            }
            if (JneHandler.categoryCompleteness()==0) {
                val = 0
            }
        }
            
          
//            if( line.trim() ) {
//              def (key,value) = line.split( ' ' ).collect { it.trim() }
//              if (parameters.contains(key)) {
//                  // --------------------------------------------------------------------
//                  // tiki
//                  if (stringfile.contains('tiki')) {
//                    file.eachLine { line ->
//                      
//                      TikiHandler.addCategory(key)
//                      if (key == "service") {
//                          if (TikiHandler.checkService(value)!=1) {
//                              val = TikiHandler.checkService(value)
//                          }
//                      }
//                    }
//                  } else { //jne
//                    file.eachLine { line ->
////                      TikiHandler.addCategory(key)
////                      if (key == "service") {
////                          if (TikiHandler.checkService(value)!=1) {
////                              val = TikiHandler.checkService(value)
////                          }
////                      }
//                    }
//                  }
//              } else {
//                  val = 0;
//              }
//            }
//            else {
//              if( driveInfo ) {
//                dataList << driveInfo
//                driveInfo = [:]
//              }
//            }
          return val;
//          if( driveInfo ) {
//            dataList << driveInfo
//          }
        }
    }
}

