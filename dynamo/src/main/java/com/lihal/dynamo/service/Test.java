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

public class Test {

	public String from = "Kopparapulihaltej.46@gmail.com";
	public String[] to = {"Kopparapulihaltej.49@gmail.com"};
	private String templateName = "Lihal";
	private String templateData = "{ \"name\":\"Jack\", \"favoriteanimal\": \"Tiger\"}";

	public String sendEmail() {

		AWSCredentials credentials = new BasicAWSCredentials("AKIAVOTSIEXAHIO6LJHM", "j9ArAJ5PTjItpAT6wQqdAF5khCbUhBOb5mOeWNCn");
		com.amazonaws.services.simpleemail.AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder
				.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.AP_SOUTH_1).build();

		Destination destination = new Destination();
		List<String> toAddresses = new ArrayList<String>();
		String[] Emails = to;

		for (String email : Emails) {
			toAddresses.add(email);
		}

		destination.setToAddresses(toAddresses);
		SendTemplatedEmailRequest templatedEmailRequest = new SendTemplatedEmailRequest();
		templatedEmailRequest.withDestination(destination);
		templatedEmailRequest.withTemplate(templateName);
		templatedEmailRequest.withTemplateData(templateData);
		templatedEmailRequest.withSource(from);
		try {
			client.sendTemplatedEmail(templatedEmailRequest);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "email sent";
	}

}
