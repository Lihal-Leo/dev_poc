package com.lihal.dynamo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lihal.dynamo.dao.StudentDao;
import com.lihal.dynamo.model.Student;

public class LambdaHandler   implements RequestHandler<String, String> {

	StudentDao studentDao = new StudentDao();
	
	@Override
	public String handleRequest(String input, Context context) {
		return "from Handler Request";
	}
	
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	
	public Student getStudentById(String studentId) {
		return studentDao.getStudentById(studentId);
	}

	
	public String updateStudentById(Student student) {
		return studentDao.updateStudentById(student);
	}
	
	public String deleteStudentById(String studentId) {
		Student student = new Student();student.setStudentId(studentId);
		return studentDao.deleteStudentById(student);
	}
	
}
