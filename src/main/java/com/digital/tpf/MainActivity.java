package com.digital.tpf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.digital.tpf.Adapters.HeadlinesAdapter;
import com.digital.tpf.Services.ApiService;
import com.digital.tpf.model.Article;
import com.digital.tpf.model.Headlines;
import com.digital.tpf.model.HeadlinesModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String headlines = "top-headlines";
    String source = "business";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        final ArrayList<HeadlinesModel> headlinesModels = new ArrayList<>();
        final HeadlinesAdapter adapter = new HeadlinesAdapter(headlinesModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<Headlines> call = api.getHeadlines(source, "in");
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {

                if (response.isSuccessful()){
                    Headlines headlines = response.body();
                    for (int i = 0; i<headlines.getArticles().size(); i++){
                        headlinesModels.add(new HeadlinesModel(headlines.getArticles().get(i).getTitle(), headlines.getArticles().get(i).getPublishedAt().toString()));
                    }
                    adapter.notifyDataSetChanged();
                }
                else {
                    System.out.println("Sorry");
                }
            }
            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                System.out.println(t.getMessage());
            }
        });



//        Call<Headlines> call = api.setPhone(phone);
//
//
//        call.enqueue(new Callback<PhoneEntry>() {
//            @Override
//            public void onResponse(Call<PhoneEntry> call, Response<PhoneEntry> response) {
//                PhoneEntry sentStatus = response.body();
//                Toast.makeText(OTPActivity.this, "otp sent response: "+sentStatus.getStatus(), Toast.LENGTH_SHORT).show();
//                signUp();
//            }
//            @Override
//            public void onFailure(Call<PhoneEntry> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}