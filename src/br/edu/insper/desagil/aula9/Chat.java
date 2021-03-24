package br.edu.insper.desagil.aula9;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	private List<Message> messages;

	public Chat() {
		this.messages = new ArrayList<>();
	}
	
	public void post(Message message) {
		this.messages.add(message);
	}
	
	public String renderAll() {
		String renderedString = "<main>";
		
		for (Message message: this.messages) {
			renderedString+= message.render();
		}
		
		return renderedString + "</main>";
	}
	
}
