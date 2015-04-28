package io;

import java.io.Serializable;
import java.time.Instant;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	// Final fields can be serialized and deserialized too (reflection is used)
	private final String text;
	private final Instant date;
	private final String sender;
	// Transient fields are not serialized
	private transient String password;

	public Message(String text, String sender) {
		super();
		this.text = text;
		this.date = Instant.now();
		this.sender = sender;
	}
	public String getText() {
		return text;
	}
	public Instant getDate() {
		return date;
	}
	public String getSender() {
		return sender;
	}
	
	@Override
	public String toString() {
		return "Date: " + date + " Sender: " + sender + " Text: " + text;
	}
	
	
}


