package org.example.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.*;


public class JAXBHandler {

    // Export
    public static void marshal(List<Student> studentList, File selectedFile)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(StudentList.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new StudentList(studentList), writer);
        writer.close();
    }

    // Import
    public static List<Student> unmarshal(File importFile) throws JAXBException {
        StudentList studentList = new StudentList();

        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Unmarshaller um = context.createUnmarshaller();
        studentList = (StudentList) um.unmarshal(importFile);

        return studentList.getStudentList();
    }

}
