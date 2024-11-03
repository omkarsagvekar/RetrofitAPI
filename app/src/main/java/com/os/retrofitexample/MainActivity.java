package com.os.retrofitexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.os.retrofitexample.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<ModelClass> list;
    RetrofitAdapter retrofitAdapter;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        binding.rvData.setLayoutManager(new LinearLayoutManager(this));
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<ModelClass>> call = retrofitApi.getModelClass();
        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                list = response.body();
                retrofitAdapter = new RetrofitAdapter(list, MainActivity.this);
                binding.rvData.setAdapter(retrofitAdapter);

                if (!response.isSuccessful()){
//                    binding.textView2.setText("error");
//                    binding.textView3.setText("error");
//                    binding.textView4.setText("error");
//                    binding.textView.setText("error");
                }
                List<ModelClass> data = response.body();
//                binding.textView2.setText("" + data.get(0).getId());
//                binding.textView3.setText("" + data.get(0).getUserId());
//                binding.textView4.setText("" + data.get(0).getTitle());
//                binding.textView.setText("" + data.get(0).getSubtitle());
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "There is an error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}