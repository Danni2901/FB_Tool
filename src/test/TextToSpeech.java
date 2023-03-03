package test;

import java.io.IOException;

public class TextToSpeech {

	public static void main(String[] args) throws IOException {
		OpenAI.TextToSpeech tts = new OpenAI.TextToSpeech();
		tts.Speech("Xin Chào tôi là fb tool Được hỗ trợ bởi OPEN AI API");
	}

}
