package org.example.xml;


import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class XMLValidator {
    public static void main(String[] args) {
        try {
            validate("src/main/resources/xml/student.xml", "src/main/resources/xml/student.xsd");
            System.out.println("Validation succeeded");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void validate(String xmlFile, String xsdFile) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        ((schemaFactory.newSchema(new File(xsdFile))).newValidator()).validate(new StreamSource(new File(xmlFile)));
    }


}
