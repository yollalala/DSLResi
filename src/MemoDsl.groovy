
import groovy.xml.MarkupBuilder

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atia
 */
class MemoDsl {
	String toText
	String fromText
	String body
	def sections = []

	def static make (closure) {
		MemoDsl memodsl = new MemoDsl()
		closure.delegate = memodsl
		closure()
	}

	def to (String toText) {
		this.toText = toText
	}

	def from (String fromText) {
		this.fromText = fromText
	}

	def body (String body) {
		this.body = body
	}

	def methodMissing(String methodname, args) {
		def section = new Section(title: methodname, body: args[0])
		sections << section
	}

	def getXml() {
		doXml(this)
	}

	def getHtml() {
		doHtml(this)
	}

	def getText() {
		doText(this)
	}

	private static doXml(MemoDsl memoDsl) {
		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)
		xml.memo() {
			to(memoDsl.toText)
			from(memoDsl.fromText)
			body(memoDsl.body)
			for (s in memoDsl.sections) {
				"$s.title"(s.body)
			}
		}
		println writer
	}

    private static doHtml(MemoDsl memoDsl) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html() {
            head {
                title("Memo")
            }
            body {
                h1("Memo")
                h3("To: ${memoDsl.toText}")
                h3("From: ${memoDsl.fromText}")
                p(memoDsl.body)
                 // cycle through the stored section objects and create uppercase/bold section with body
                for (s in memoDsl.sections) {
                    p {
                        b(s.title.toUpperCase())
                    }
                    p(s.body)
                }
            }
        }
        println writer
    }

    private static doText(MemoDsl memoDsl) {
        String template = "Memo\nTo: ${memoDsl.toText}\nFrom: ${memoDsl.fromText}\n${memoDsl.body}\n"
        def sectionStrings =""
        for (s in memoDsl.sections) {
            sectionStrings += s.title.toUpperCase() + "\n" + s.body + "\n"
        }
        template += sectionStrings
        println template
    }
}

