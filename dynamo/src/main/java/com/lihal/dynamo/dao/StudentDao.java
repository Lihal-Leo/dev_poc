package com.lihal.dynamo.dao;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.lihal.dynamo.model.Student;
import com.lihal.dynamo.util.Constants;


public class StudentDao {

	private DynamoDBMapper dynamoDBMapper;
	
	public StudentDao() {
		this.dynamoDBMapper = getDynamoDbMapper();
	}
	
	public DynamoDBMapper getDynamoDbMapper() {
		
		AmazonDynamoDB amazonDynamoDB
	        = AmazonDynamoDBClientBuilder.standard()
	        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(Constants.SERVICE_ENDPOINT, Constants.REGION))
	        .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(Constants.ACCESS_KEY, Constants.SECRET_KEY))).build();
		return new DynamoDBMapper(amazonDynamoDB);
	}
	
	public Student saveStudent(Student student) {
		if(dynamoDBMapper == null ) {this.dynamoDBMapper = getDynamoDbMapper();}
		dynamoDBMapper.save(student);
		return student;
	}
	
	public Student getStudentById(String studentId) {
		if(dynamoDBMapper == null ) {this.dynamoDBMapper = getDynamoDbMapper();}
		return dynamoDBMapper.load(Student.class,studentId);
	}
	
	public String deleteStudentById(Student student) {
		try {
			dynamoDBMapper.delete(student);
		}catch(Exception e) {e.printStackTrace(); return "failed to delete, error:"+e.getMessage();}
		return "Deleted Successfully..!!";
	}
	
	public String updateStudentById(Student student) {
		try {
			dynamoDBMapper.save(student,buildExpression(student));
		}catch(Exception e) {e.printStackTrace(); return "failed to update, error:"+e.getMessage();}
		return "Updated Successfully..!!";
	}
	
	
	public DynamoDBSaveExpression buildExpression(Student student) {
		
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("studentId",new ExpectedAttributeValue(new AttributeValue().withS(student.getStudentId())));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}
}
