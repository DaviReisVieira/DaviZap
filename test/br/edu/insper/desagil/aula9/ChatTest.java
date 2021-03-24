package br.edu.insper.desagil.aula9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChatTest {
	private Chat chat;

	@BeforeEach
	public void setUp() {
		chat = new Chat();
	}

	@Test
	public void testeVazio() {
		assertEquals("<main></main>", chat.renderAll());
	}
	
	@Test
	public void testeTresMensagens() {
		chat.post(new Message("davi", "Hello davi!"));
		chat.post(new Message("gio", "Hello gio!"));
		chat.post(new Message("reis", "Hello reis!"));
		
		assertEquals(
			"<main>" +
			"<p><strong>davi:</strong>Hello davi!</p>" +
			"<p><strong>gio:</strong>Hello gio!</p>" +
			"<p><strong>reis:</strong>Hello reis!</p>" +
			"</main>",
		chat.renderAll());
	}
	
	@Test
	public void testeTresMensagensComImagem() {
		chat.post(new ImageMessage("davi", "Hello davi!", "helloDavi.png"));
		chat.post(new ImageMessage("gio", "Hello gio!", "helloGio.png"));
		chat.post(new ImageMessage("reis", "Hello reis!", "helloReis.png"));
		
		assertEquals(
			"<main>" +
			"<figure><p><strong>davi:</strong>Hello davi!</p><img src=\"helloDavi.png\"></figure>" +
			"<figure><p><strong>gio:</strong>Hello gio!</p><img src=\"helloGio.png\"></figure>" +
			"<figure><p><strong>reis:</strong>Hello reis!</p><img src=\"helloReis.png\"></figure>" +
			"</main>",
		chat.renderAll());
	}
	
	@Test
	public void testeTresMensagensComVideo() {
		chat.post(new VideoMessage("davi", "Hello davi!", "helloDavi.mp4"));
		chat.post(new VideoMessage("gio", "Hello gio!", "helloGio.mp4"));
		chat.post(new VideoMessage("reis", "Hello reis!", "helloReis.mp4"));
		
		assertEquals(
			"<main>" +
			"<figure><p><strong>davi:</strong>Hello davi!</p><video src=\"helloDavi.mp4\"></figure>" +
			"<figure><p><strong>gio:</strong>Hello gio!</p><video src=\"helloGio.mp4\"></figure>" +
			"<figure><p><strong>reis:</strong>Hello reis!</p><video src=\"helloReis.mp4\"></figure>" +
			"</main>",
		chat.renderAll());
	}
	
	@Test
	public void testeTresMensagensDiferentes() {
		chat.post(new Message("davi", "Hello davi!"));
		chat.post(new ImageMessage("gio", "Hello gio!", "helloGio.png"));
		chat.post(new VideoMessage("reis", "Hello reis!", "helloReis.mp4"));
		
		assertEquals(
			"<main>" +
			"<p><strong>davi:</strong>Hello davi!</p>" +
			"<figure><p><strong>gio:</strong>Hello gio!</p><img src=\"helloGio.png\"></figure>" +
			"<figure><p><strong>reis:</strong>Hello reis!</p><video src=\"helloReis.mp4\"></figure>" +
			"</main>",
		chat.renderAll());
	}

}
