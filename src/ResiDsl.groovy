
import groovy.xml.MarkupBuilder
import java.util.Random
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atia
 */
class ResiDsl {
        String noResi
        String kodeWilayahPenerima
	String kepadaText
        String alamatPenerima
        String telpPenerima
        String kodeWilayahPengirim
	String dariText
        String alamatPengirim
        String telpPengirim
        String jumlahTitipan
        String deskripsi
        String rincianBerat
        String service
        String biayaKirim
        String biayaTambahan
        
        String tipeBarang
//	String body
	def sections = []

	def static make (closure) {
		ResiDsl resiDsl = new ResiDsl()
		closure.delegate = resiDsl
		closure()
	}

        def noResi (String noResi) {
            // generate no resi
		this.noResi = noResi
	}
        
        def String generateNoResi() {
//            return "121212121"
              String temp = "0" + Math.abs(new Random().nextInt() % 9999999 + 20100000000).toString()
              return temp
//              return temp[0-2] + " " + temp[2-5] + " " + temp[5-8] + " " + temp[8-12]
        }
        
        def kodeWilayahPenerima (String kodeWilayahPenerima) {
            // ambil dari database
            this.kodeWilayahPenerima = kodeWilayahPenerima
        }
    
	def kepada (String kepadaText) {
		this.kepadaText = kepadaText
	}
        
        def alamatPenerima (String alamatPenerima) {
            this.alamatPenerima = alamatPenerima
        }
        
        def telpPenerima (String telpPenerima) {
            this.telpPenerima = telpPenerima
        }
        
        def kodeWilayahPengirim (String kodeWilayahPengirim) {
            // ambil dari database
            this.kodeWilayahPengirim = kodeWilayahPengirim
        }

	def dari (String dariText) {
		this.dariText = dariText
	}
        
        def alamatPengirim (String alamatPengirim) {
            this.alamatPengirim = alamatPengirim
        }
    
        def telpPengirim (String telpPengirim) {
            this.telpPengirim = telpPengirim
        }
        
        def deskripsi (String [] deskripsi) {
            // nama-nama barang kiriman
            this.deskripsi = deskripsi
        }
        
        def rincianBerat (String [] rincianBerat) {
            this.rincianBerat = rincianBerat
        }
        
        def service (int service) {
            this.service = service
        }

//	def body (String body) {
//		this.body = body
//	}

	def methodMissing(String methodname, args) {
		def section = new Section(title: methodname, body: args[0])
		sections << section
	}

//	def getXml() {
//		doXml(this)
//	}

	def getTiki() {
		doTiki(this)
	}
        
        def getJne() {
		doJne(this)
	}

//	def getText() {
//		doText(this)
//	}

//	private static doXml(ResiDsl resiDsl) {
//		def writer = new StringWriter()
//		def xml = new MarkupBuilder(writer)
//		xml.memo() {
//			kepada(resiDsl.kepadaText)
//			dari(resiDsl.dariText)
//			body(resiDsl.body)
//			for (s in resiDsl.sections) {
//				"$s.title"(s.body)
//			}
//		}
//		println writer
//	}

    private static String doTiki(ResiDsl resiDsl) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html(lang:"en") {
            head {
                title ("Resi Pengiriman")
                meta ('charset':"utf-8")
                meta ('name':'viewport', 'content':'width=device-width, initial-scale=1')
                link (rel:"stylesheet", href:"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css")
                script ('', src:'https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js')
                script ('', src:'http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js')
            }
            body {
                div (class:"container") {
                    h2 ("Resi Pengiriman Tiki")
                    div (class:"panel panel-default") {
                        div (class:"panel-body") {
                            form (role:"form") {
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("No. Resi")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.generateNoResi(), class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Kode wilayah")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.kodeWilayahPenerima, class:"form-control-static")
                                     }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Kepada")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.kepadaText, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Alamat Penerima")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.alamatPenerima, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Telp / Fax")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.telpPenerima, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Kode wilayah")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.kodeWilayahPengirim, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Dari")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.dariText, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Alamat Pengirim")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.alamatPengirim, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Telp / Fax")
                                    }
                                    div (class:"col-md-9") {
                                        p (resiDsl.telpPengirim, class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Isi menurut pengakuan")
                                    }
                                    div (class:"col-md-9") {
                                        p ("Spare part computer", class:"form-control-static")
                                    }
                                }
//                                div (class:"form-group") {
//                                    label (class:"col-md-3") {
//                                        b ("Perincian berat volume")
//                                    }
//                                    div (class:"col-md-9") {
//                                        p ("-", class:"form-control-static")
//                                    }
//                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Services")
                                    }
                                    div (class:"col-md-9") {
                                        p ("ONS", class:"form-control-static")
//                                        div (class:"checkbox") {
//                                          label { input ("SS", type:"checkbox", value:"")}
//                                        }
//                                        div (class:"checkbox checked") {
//                                          label { input ("ONS", type:"checkbox", value:"")}
//                                        }
//                                        div (class:"checkbox") {
//                                          label { input ("TDS", type:"checkbox", value:"")}
//                                        }
//                                        div (class:"checkbox") {
//                                          label { input ("REG", type:"checkbox", value:"")}
//                                        }
//                                        div (class:"checkbox") {
//                                          label { input ("Packing", type:"checkbox", value:"")}
//                                        }
//                                        div (class:"checkbox") {
//                                          label { input ("Insurance", type:"checkbox", value:"")}
//                                        }  
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Biaya kirim")
                                    }
                                    div (class:"col-md-9") {
                                        p ("100000", class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("Biaya tambahan")
                                    }
                                    div (class:"col-md-9") {
                                        p ("10000", class:"form-control-static")
                                    }
                                }
                                div (class:"form-group") {
                                    label (class:"col-md-3") {
                                        b ("TOTAL")
                                    }
                                    div (class:"col-md-9") {
                                        p (("100000".toInteger() + "10000".toInteger()).toString(), class:"form-control-static")
                                    }
                                }

                                div (class:"form-group") {
                                    div ("", class:"col-md-9")
                                    div ("Bandung, 1 Desember 2015", class:"col-md-3")
                                }
                                div (class:"form-group") {
                                    div ("", class:"col-md-9")
                                    div (class:"col-md-3") {
                                          br()
                                          b ("Gerai Bandung")
                                    }
                                }
                            }
                        }
                    }
                }
                
//                h1("Memo")
//                h3("Kepada: ${resiDsl.kepadaText}")
//                h3("Dari: ${resiDsl.dariText}")
//                h3("No Resi: ${resiDsl.noResi}")
//                p(resiDsl.body)
//                 // cycle through the stored section objects and create uppercase/bold section with body
//                for (s in resiDsl.sections) {
//                    p {
//                        b(s.title.toUpperCase())
//                    }
//                    p(s.body)
//                }
            }
        }
        return writer
    }
    
    private static String doJne(ResiDsl resiDsl) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html(lang:"en") {
            head {
                title ("Resi Pengiriman Jne")
                meta ('charset':"utf-8")
                meta ('name':'viewport', 'content':'width=device-width, initial-scale=1')
                link (rel:"stylesheet", href:"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css")
                script ('', src:'https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js')
                script ('', src:'http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js')
            }
            body {
                h1("Resi Pengiriman JNE")
                h3("Kepada: ${resiDsl.kepadaText}")
                h3("Dari: ${resiDsl.dariText}")
                h3("No Resi: ${resiDsl.noResi}")
//                p(resiDsl.body)
//                 // cycle through the stored section objects and create uppercase/bold section with body
//                for (s in resiDsl.sections) {
//                    p {
//                        b(s.title.toUpperCase())
//                    }
//                    p(s.body)
//                }
            }
        }
        return writer
    }

//    private static doText(ResiDsl resiDsl) {
//        String template = "Memo\nKepada: ${resiDsl.kepadaText}\nDari: ${resiDsl.dariText}\n${resiDsl.body}\n"
//        def sectionStrings =""
//        for (s in resiDsl.sections) {
//            sectionStrings += s.title.toUpperCase() + "\n" + s.body + "\n"
//        }
//        template += sectionStrings
//        println template
//    }
}
