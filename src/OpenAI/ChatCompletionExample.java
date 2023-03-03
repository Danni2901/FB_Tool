package OpenAI;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

public class ChatCompletionExample{
    public String OpenAI(String question) {
	KeyApi keyApi = new KeyApi();
    	String  answer = "";
        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\""+question+"\"}]}");
        Request request = new Request.Builder()
          .url("https://api.openai.com/v1/chat/completions")
          .post(body)
          .addHeader("Authorization","Bearer "+ keyApi.getKeyOpenAI())
          .addHeader("Content-Type", "application/json")
          .build();
        try {
        	Response response = client.newCall(request).execute();
            // Đọc câu trả lời từ phản hồi của API
            JsonNode responseJson = mapper.readTree(response.body().byteStream());
            answer = responseJson.get("choices").get(0).get("message").get("content").asText();
            // Hiển thị câu trả lời
            System.out.println(answer);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return answer;
    }
}

