package com.lihal.dynamo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import com.lihal.dynamo.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Application Started...!!" );
        new App().getStudentById();
        //System.out.println(new App().getPageContents("https://checkip.amazonaws.com"));
    }
    
    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
    
    
    public void getStudentById() {
    	 System.out.println(new LambdaHandler().getStudentById("fb68c7d5-f998-4734-b2d2-e5f315ff0900"));
    }
    
    public void saveStudent() {
    	Student student = new Student();
        student.setStudentaddress("Ubuntu");
        student.setStudentContactNo("666666");
        student.setStudentEmailId("Linux@gamil.com");
        student.setStudentName("Linux");
        System.out.println(new LambdaHandler().saveStudent(student));
    }
    
    public void updateStudentById() {
    	Student student = new Student();
        student.setStudentaddress("Kali");
        student.setStudentContactNo("666666");
        student.setStudentEmailId("Kali@gamil.com");
        student.setStudentName("Kali");
        student.setStudentId("643e37b7-8706-4337-b760-98661633f84c");
   	 System.out.println(new LambdaHandler().updateStudentById(student));
   }
    public void deleteStudentById() {
   	 System.out.println(new LambdaHandler().deleteStudentById("643e37b7-8706-4337-b760-98661633f84c"));
   }
}
