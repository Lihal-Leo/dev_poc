package com.lihal.dynamo.service;

import java.util.Map;
import java.util.TreeMap;

public class V4Test {

	  public static void main(String[] args) {
	        String url = "https://email.ap-south-1.amazonaws.com";
	        
	        /**
	         * Add host without http or https protocol.
	         * You can also add other parameters based on your amazon service requirement.
	         */
	        TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
	        awsHeaders.put("host", "xxxxx-yyyyy-r6nvlhpscgdwms5.ap-northeast-1.es.amazonaws.com");
	        
	        AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder("AKIAVOTSIEXAHIO6LJHM", "j9ArAJ5PTjItpAT6wQqdAF5khCbUhBOb5mOeWNCn")
	                                           .regionName("ap-south-1")
	                                           .serviceName("email") // es - elastic search. use your service name
	                                           .httpMethodName("GET") //GET, PUT, POST, DELETE, etc...
	                                           .canonicalURI("/email.ap-south-1.amazonaws.com") //end point
	                                           .queryParametes(null) //query parameters if any
	                                           .awsHeaders(awsHeaders) //aws header parameters
	                                           .payload(null) // payload if any
	                                           .debug() // turn on the debug mode
	                                           .build();
	        
	        /* Get header calculated for request */
	        Map<String, String> header = aWSV4Auth.getHeaders();
	        for (Map.Entry<String, String> entrySet : header.entrySet()) {
	            String key = entrySet.getKey();
	            String value = entrySet.getValue();
	            
	            /* Attach header in your request */
	            /* Simple get request */
	            //HttpGet httpGet = new HttpGet(url);
	            //httpGet.addHeader(key, value);
	        }
	        // execute httpGet
	    }
}
