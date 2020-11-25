package org.algosketch.eum;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/v2/everything")
    Call<FeedVO> getFeeds(@Query("q") String q,
                         @Query("api_key") String apiKey,
                         @Query("result") long result);
}
