package com.lihal.dynamo.model;

import java.util.Arrays;

public class EmailData {

	public String[] to;
	public String name;
	public String orgName;
	public String template;
	public String contatcEmail;
	public String contactNumber;
	public String metaData;
	
	
	public String[] getTo() {
		return to;
	}


	public void setTo(String[] to) {
		this.to = to;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getTemplate() {
		return template;
	}


	public void setTemplate(String template) {
		this.template = template;
	}


	public String getContatcEmail() {
		return contatcEmail;
	}


	public void setContatcEmail(String contatcEmail) {
		this.contatcEmail = contatcEmail;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getMetaData() {
		return metaData;
	}


	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}


	@Override
	public String toString() {
		return "EmailData [to=" + Arrays.toString(to) + ", name=" + name + ", orgName=" + orgName + ", template="
				+ template + ", contatcEmail=" + contatcEmail + ", contactNumber=" + contactNumber + ", metaData="
				+ metaData + "]";
	}
	
	
}
