/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atia
 */
class JneHandler {
        static def categories = []
        static List mandatory = ["kepada", "alamatpengirim", "alamatpenerima", "dari", "jumlahtitipan", "berat", "biayakirim", "biayatambahan", "tipebarang", "service"]
	public static int checkService(String value) {
            def values = "intracity diplomat SS REG YES OKE international others".split()
            String con = value.replace("\"","")
            if (values.contains(con)) {
                return 1
            } else {
                return 5
            }
        }
        
        public static int categoryCompleteness() {
            if (categories.containsAll(mandatory)) {
                return 1
            } else {
                return 0
            }
        }
        
        public static void addCategory(String category) {
//            println category
            categories << category
        }
        
        public static void printCategories() {
            for (int i=0; i<categories.size; i++) {
                println categories[i]
            }
        }
        
	public static int checkTipeBarang(String value) {
            def values = "parcel document".split()
            String con = value.replace("\"","")
            if (values.contains(con)) {
                return 1
            } else {
                return 5
            }
        }
}

