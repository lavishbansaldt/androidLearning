package com.example.retrofit;

import com.example.androidlearning.RetrofitDemoPost;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitDemoJSONPlaceholderAPI {

    /*@GET ("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order);*/
    @GET("posts")
    Call<List<RetrofitDemoPost>> getPosts(@QueryMap Map<String, String> parameters);

   @GET("comments")
    Call<List<RetrofitDemoComment>> getComments();

    @GET("posts/{id}/comments")
    Call<List<RetrofitDemoComment>> getComments(@Path("id") Integer postId);

    @POST("posts")
    Call<RetrofitDemoPost> sendPost(@Body RetrofitDemoPost post);

    /*@FormUrlEncoded
    @POST("posts")
    Call<Post> sendPost(
            @Field("userId") int userId,
            @Field("title") String postTitle,
            @Field("body") String postBody);*/

    @FormUrlEncoded
    @POST("posts")
    Call<RetrofitDemoPost> sendPost(@FieldMap Map<String, String> parametersMap);



}
