package com.example.retrofit;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlearning.R;
import com.example.androidlearning.RetrofitDemoPost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDemo extends AppCompatActivity {

    private TextView mAPIResult;
    private RetrofitDemoJSONPlaceholderAPI mJsonPlaceholderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        mAPIResult = findViewById(R.id.display_api_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mJsonPlaceholderAPI = retrofit.create(RetrofitDemoJSONPlaceholderAPI.class);



        //getComments();
        //getPosts();
        sendPost();


    }

    private void getPosts(){
        //here in the id field use the exact same field name as in the jsonholder api and not those in pojo class
       // Call<List<Post>> call = mJsonPlaceholderAPI.getPosts(new Integer[]{1,2,3}, "id", "desc");

        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("userId", "1");
        parametersMap.put("userId", "2");
        parametersMap.put("userId", "3");
        parametersMap.put("_sort", "id");
        parametersMap.put("_order", "desc");


        Call<List<RetrofitDemoPost>> call = mJsonPlaceholderAPI.getPosts(parametersMap);


        call.enqueue(new Callback<List<RetrofitDemoPost>>() {
            @Override
            public void onResponse(Call<List<RetrofitDemoPost>> call, Response<List<RetrofitDemoPost>> response) {

                if(!response.isSuccessful()){
                    mAPIResult.setText("CODEE: " + response.code() );
                }
                List<RetrofitDemoPost> posts = response.body();
                String result = "";
                for(RetrofitDemoPost post : posts){
                    result+= "PostId: " + post.getPostId() + "\n";
                    result+= "UserId: " + post.getUserId() + "\n";

                    result+= "PostTitle: " + post.getPostTitle() + "\n";
                    result+= "PostBody: " + post.getPostBody() + "\n\n";
                }

                mAPIResult.setText(result);
            }

            @Override
            public void onFailure(Call<List<RetrofitDemoPost>> call, Throwable t) {
                mAPIResult.setText(t.getMessage());
            }
        });
    }


    private void getComments(){
        Call<List<RetrofitDemoComment>> call = mJsonPlaceholderAPI.getComments();

        call.enqueue(new Callback<List<RetrofitDemoComment>>() {
            @Override
            public void onResponse(Call<List<RetrofitDemoComment>> call, Response<List<RetrofitDemoComment>> response) {
                if(!response.isSuccessful()){
                    mAPIResult.setText("CODE: " + response.code());
                }

                List<RetrofitDemoComment> comments = response.body();

                for(RetrofitDemoComment comment : comments){
                    String result= "";
                    result+= "PostId: " + comment.getPostId() + "\n";
                    result+= "UserId: " + comment.getUserId() + "\n";
                    result+= "UserName: " + comment.getUserName() + "\n";
                    result+= "EmailAddress: " + comment.getEmailAddress() + "\n";
                    result+= "EmailBody: " + comment.getEmailBody() + "\n\n";
                    mAPIResult.append(result);
                }
            }

            @Override
            public void onFailure(Call<List<RetrofitDemoComment>> call, Throwable t) {
                    mAPIResult.setText(t.getMessage());
            }
        });
    }


    private void sendPost(){

        //Post post = new Post(5, "My Post", "My Post Body");
        //Call<Post> call = mJsonPlaceholderAPI.sendPost(9, "New Post Title", "New Post Body");

        Map<String, String> parametersMap= new HashMap<>();
        parametersMap.put("userId", "2");
        parametersMap.put("title", "3rd way to post");

        Call<RetrofitDemoPost> call = mJsonPlaceholderAPI.sendPost(parametersMap);

        call.enqueue(new Callback<RetrofitDemoPost>() {
            @Override
            public void onResponse(Call<RetrofitDemoPost> call, Response<RetrofitDemoPost> response) {
                if(!response.isSuccessful()){
                    mAPIResult.setText("Code: " + response.code());
                }

                RetrofitDemoPost postResponse= response.body();
                String result= "";
                result= "Code: " + response.code() + "\n";
                result+= "PostId: " + postResponse.getPostId() + "\n";
                result+= "UserId: " + postResponse.getUserId() + "\n";
                result+= "PostTitle: " + postResponse.getPostTitle() + "\n";
                result+= "PostBody: " + postResponse.getPostBody() + "\n\n";

                mAPIResult.setText(result);

            }

            @Override
            public void onFailure(Call<RetrofitDemoPost> call, Throwable t) {
                mAPIResult.setText(t.getMessage());
            }
        });
    }
}