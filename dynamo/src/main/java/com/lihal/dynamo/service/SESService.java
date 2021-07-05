package com.lihal.dynamo.service;
import java.util.ArrayList;
import java.util.List;



import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest;
import com.lihal.dynamo.model.EmailData;
public class SESService {

	
	public String from = "Kopparapulihaltej.46@gmail.com";
	
	
	
	public String sendEmail(EmailData emailData) {

		if(emailData == null || emailData.to == null || emailData.to.length == 0) {System.out.println(emailData.toString()); return "Please Provide Proper Input Format";}
		try {
			AWSCredentials credentials = new BasicAWSCredentials("AKIAVOTSIEXAHIO6LJHM", "j9ArAJ5PTjItpAT6wQqdAF5khCbUhBOb5mOeWNCn");
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder
					.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.AP_SOUTH_1).build();

			Destination destination = new Destination();
			List<String> toAddresses = new ArrayList<String>();
			String[] Emails = emailData.to;
			String templateData = "{ \"name\": \""+emailData.name+"\", \"store\": \""+emailData.orgName+"\", \"metadata\": \""+emailData.metaData+"\", \"email\" : \""+emailData.contatcEmail+"\", \"number\" : \""+emailData.contactNumber+"\" }";

			for (String email : Emails) {
				toAddresses.add(email);
			}

			destination.setToAddresses(toAddresses);
			SendTemplatedEmailRequest templatedEmailRequest = new SendTemplatedEmailRequest();
			templatedEmailRequest.withDestination(destination);
			templatedEmailRequest.withTemplate(emailData.template);
			templatedEmailRequest.withTemplateData(templateData);
			templatedEmailRequest.withSource(from);
			templatedEmailRequest.withReturnPath(from);
			try {
				client.sendTemplatedEmail(templatedEmailRequest);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
