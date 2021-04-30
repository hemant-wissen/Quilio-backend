package com.conversations.twilio.conversation.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.conversations.v1.Conversation;

@RestController
public class ConversationRestController {
	public static final String ACCOUNT_SID = "AC387561c4b89e34f8eac3cc85e79f9223";
    public static final String AUTH_TOKEN = "380367a9c1927961c4df09ea23066329";
	
	@GetMapping("/")
	public String message() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		System.out.println("twilio authentication done");
		
//		Conversation conversation = Conversation.creator()
//	            .setMessagingServiceSid(
//	                "MGXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
//	            .setFriendlyName("Friendly Conversation")
//	            .create();
		
		ResourceSet<Conversation> conversations = Conversation.reader()
	            .limit(20).read();

	        for(Conversation record : conversations) {
	        	System.out.println("entered conversation");
	            System.out.println(record.getSid());
	        }
		return "Hi, How can I help you?";
	}

}
