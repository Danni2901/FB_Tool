package OpenAI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import bsh.Console;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TextToSpeech {
	public void Speech(String Text) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, Text);
		Request request = new Request.Builder().url("https://api.fpt.ai/hmi/tts/v5").method("POST", body)
				.addHeader("api-key", "UaxiFMFPi8JXIu1BwZvPvFFgxgxjajmK").addHeader("speed", "")
				.addHeader("voice", "minhquang").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			try {
				String json = response.body().string();
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root = mapper.readTree(json);
				String asyncLink = root.get("async").asText();
				System.out.println("Async link: " + asyncLink);

				// Extract file name from the async link
				String fileName = asyncLink.substring(asyncLink.lastIndexOf("/") + 1);

//    	            try {
//						Thread.sleep(100);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						System.out.println("Loi o day");
//					}
				// Create a new request to download the file
				Request downloadRequest = new Request.Builder().url(asyncLink).build();

				Response downloadResponse = client.newCall(downloadRequest).execute();
				if (downloadResponse.isSuccessful()) {

					try (InputStream inputStream = downloadResponse.body().byteStream()) {
						FileOutputStream outputStream = new FileOutputStream(fileName);
						byte[] buffer = new byte[1024];
						int bytesRead = 0;
						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}
						outputStream.close();
						inputStream.close();
						System.out.println("File downloaded successfully!");
					} catch (IOException e) {
						throw new RuntimeException("Failed to close input stream", e);
					}
				} else {
					System.out.println("Failed to download!");
				}

				MP3Player player = new MP3Player("./" + fileName);
				player.play();

			} catch (IOException e) {
				throw new RuntimeException("Failed to parse response", e);
			}
		} else {
			System.out.println("Failed to get async link!");
		}

	}
}
