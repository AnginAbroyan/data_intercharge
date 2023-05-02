package org.example.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;


public class JAXBDemo {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<Student>();



        Student student = new Student();
        student.setFirstName("Anna");
        student.setMarks(95);
        student.setLastName("Frank");
        student.setNickName("Ann");

        Student student1 = new Student();
        student1.setFirstName("John");
        student1.setMarks(95);
        student1.setLastName("Doe");
        student1.setNickName("John");


        studentList.add(student);
        studentList.add(student1);

//        Marshalling: Writing Java objects to XMl file
        try {
            JAXBHandler.marshal(studentList, new File("src/main/resources/xml/students_demo.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


//
//        Unmarshalling: Converting XML content to Java objects
//        try {
//            studentList = JAXBHandler.unmarshal(new File("src/main/resources/xml/student.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        System.out.println(studentList);

    }
}

