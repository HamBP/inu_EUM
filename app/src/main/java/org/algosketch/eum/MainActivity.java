package org.algosketch.eum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static String API_KEY = "2A92X87A2NJF3ZPD"; // query ... api key ... &result=2;
    FeedVO feeds;
    RecyclerView recyclerView;
    Button updateButton;

    RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 뷰 바인딩
        recyclerView = findViewById(R.id.recyclerview);
        updateButton = findViewById(R.id.btn_update);

        // Retrofit2 관련 객체 생성 (서버 데이터 요청, 파싱)
        retrofitService = RetrofitFactory.create();

        // 버튼 - 이벤트 연결
        updateButton.setOnClickListener(new UpdateOnClickListener());
    }

    // 버튼 클릭시 데이터 요청
    private class UpdateOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            retrofitService.getFeeds(API_KEY, 2).enqueue(new Callback<FeedVO>() {
                @Override
                public void onResponse(Call<FeedVO> call, Response<FeedVO> response) {
                    if(response.isSuccessful()) {
                        Log.i("algoi : ", "success");
                        feeds = response.body();

                        // 제목, 업데이트 시각 표시
                        TextView titleView = findViewById(R.id.title_view);
                        TextView lastUpdateView = findViewById(R.id.last_update_view);
                        titleView.setText(feeds.channel.name);
                        lastUpdateView.setText(feeds.channel.updated_at);
                        // 리스트
                        ArrayList<String> fieldNames = new ArrayList<>();
                        fieldNames.add(feeds.channel.field1);
                        fieldNames.add(feeds.channel.field2);
                        fieldNames.add(feeds.channel.field3);
                        int numOfData = feeds.feeds.size();
                        List<FeedVO.Feed> cutFeeds = feeds.feeds.subList(numOfData-20, numOfData);
                        FCMRecyclerAdapter adapter = new FCMRecyclerAdapter(cutFeeds, fieldNames);
                        recyclerView.setAdapter(adapter);
                        recyclerView.scrollToPosition(20-1);
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
}