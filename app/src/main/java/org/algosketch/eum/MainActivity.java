package org.algosketch.eum;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import static org.algosketch.eum.RetrofitFactory.create;

public class MainActivity extends Activity {
    private static String query = "feeds.json";
    private static String API_KEY = "2A92X87A2NJF3ZPD"; // query ... api key ... &result=2;
    FeedVO feeds;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result_view);

        RetrofitService retrofitService = RetrofitFactory.create();
        retrofitService.getFeeds(query, API_KEY, 2).enqueue(new Callback<FeedVO>() {
            @Override
            public void onResponse(Call<FeedVO> call, Response<FeedVO> response) {
                if(response.isSuccessful()) {
                    textView.setText(response.body().toString());
                } else {
                    Log.d("algod : ", "fail");
                }
            }

            @Override
            public void onFailure(Call<FeedVO> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}