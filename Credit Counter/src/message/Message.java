package message;

import code.Day;

public class Message extends Day{
	/*	Rates
	 * MON-FRI 6AM-8:59PM = 0.20
	 * MON-FRI 9PM-5:59PM =
	 * SAT&SUN 6AM-8:59PM =
	 * SAT&SUN 9PM-5:59PM =
	 */
	private int messageType;
	private int messageCounter;
	
	public Message() {
//		this.messageType = MessageType.LOCAL.ordinal();
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
