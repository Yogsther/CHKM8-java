import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Java client for CHKM8 Olle Kaiser, 2019
 */

class main {
    public static void main(String[] args) {
        for (String arg : args) {
            // :)
            System.out.println(arg);
        }

        // 43B755AAAE2A19BA28DFE9B22CB434C15BA86C83
        String postUrl = "https://dev.chk.ygstr.com/api/user/check";// put in your url
        Gson gson = new Gson();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(postUrl);

        TokenPayload test = new TokenPayload("43B755AAAE2A19BA28DFE9B22CB434C15BA86C83");
        try {
            StringEntity postingString = new StringEntity(gson.toJson(test));

            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");

            try {
                HttpResponse response = httpClient.execute(post);
                System.out.println(response.toString());
            } catch (IOException e) {

            }
        } catch (UnsupportedEncodingException e) {

        }

    }
}
