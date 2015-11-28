package tesgroovy;

class Test {
	public static void main (String [] args) {
		/*
		def strings = []
		new File('dslinput.txt').eachLine { line ->
			strings << line
		}
		*/
		String string = new File('dslinput.txt').text
		new GroovyShell().evaluate(string)
	}
        
//        public String bacaFile() {
//            String string = new File('D:/dslinput.txt').text
//            string = new GroovyShell().evaluate(string)
//            
//            return string; 
//        }
}