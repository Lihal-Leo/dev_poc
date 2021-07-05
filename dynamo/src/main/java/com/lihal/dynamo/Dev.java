package com.lihal.dynamo;



import com.lihal.dynamo.model.EmailData;

import com.lihal.dynamo.service.SESService;
import com.lihal.dynamo.service.Test;

public class Dev {

	public static void main(String[] args) {
		EmailData emailData = new EmailData();
		emailData.contactNumber = "9998887771";
		emailData.contatcEmail = "lihal@gmail.com";
		emailData.orgName = "Lihals_Store";
		emailData.name = "Rahul";
		emailData.template = "Store";
		String[] toUsers = {"Kopparapulihaltej.49@gmail.com"};
		emailData.to = toUsers;
		emailData.metaData = "Welcome to out Store, wehere you can find n number of items, with vraible range of price again these prices matches with the quality ratio";
		
		SESService sesService = new SESService();
		System.out.println(sesService.sendEmail(emailData));
		
	}
}
