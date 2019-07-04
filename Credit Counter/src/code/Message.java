package code;

import enums.MessageType;

public class Message extends Day{

	private int messageType;
	private int messageCounter;
	
	public Message() {
		this.messageType = MessageType.LOCAL.ordinal();
	}
	
	public Message(int messageType, int messageCounter) {
		this.messageType = messageType;
		this.messageCounter = messageCounter;
	}
		
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	
	public int getNumberOfMessages() {
		return messageCounter;
	}
	public void setMessageCounter(int messageCounter) {
		this.messageCounter = messageCounter;
	}
	
	
	}
