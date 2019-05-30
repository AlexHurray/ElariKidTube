package com.mks.elarikidtube.api;


import com.mks.elarikidtube.model.ModelData;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeEndpoint {
    @GET("/youtube/v3/search")
    Single<ModelData> getResults(@Query("part") String part,
                                 @Query("q") String q,
                                 @Query("maxResults") String maxResults,
                                 @Query("type") String type);

    @GET("/youtube/v3/search")
    Single<ModelData> getRelatedVideos(@Query("part") String part,
                                       @Query("relatedToVideoId") String relatedToVideoId,
                                       @Query("type") String type);
}
