package org.algosketch.eum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends Activity {
    WebView chartView;
    WebView mapView;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chartView = findViewById(R.id.chart_view);
        mapView = findViewById(R.id.map_view);

        chartView.getSettings().setJavaScriptEnabled(true);
        chartView.getSettings().setBuiltInZoomControls(true);
        chartView.getSettings().setSupportZoom(true);
        chartView.loadUrl("https://thingspeak.com/channels/687408/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");

        mapView.getSettings().setJavaScriptEnabled(true);
        mapView.loadUrl("https://thingspeak.com/channels/687408/maps/channel_show");

        /* TODO : 나중에 각 데이터 값이 필요할 때 사용
        resultView = findViewById(R.id.text_view_result);

        queue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.GET, "https://api.thingspeak.com/channels/687408/feeds.json?results=2",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    resultView.setText(response.getJSONObject("channel").getString("name"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(jsonRequest);

         */
    }
}