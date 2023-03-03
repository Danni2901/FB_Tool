package test;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class TextToSpeech {
	public void setSoTimeout(int timeout) throws SocketException{}

	public static void main(String[] args) throws IOException {
//		OpenAI.TextToSpeech tts = new OpenAI.TextToSpeech();
//		tts.Speech("Xin Chào tôi là fb tool Được hỗ trợ bởi OPEN AI API");
		Socket socket = new Socket();
		System.out.println("1");
		socket.setSoTimeout(5000); // set timeout là 5000ms = 5 giây
		System.out.println("2");
		
	}

}
