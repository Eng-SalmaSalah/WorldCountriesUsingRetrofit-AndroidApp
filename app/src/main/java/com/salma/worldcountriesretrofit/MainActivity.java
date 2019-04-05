package com.salma.worldcountriesretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView countriesListView;
    WorldCountriesAdapter worldCountriesAdapter;
    List<Worldpopulation> worldpopulation;
    JsonResponse countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countriesListView=findViewById(R.id.countriesList);
        loadJson();
    }

    private void loadJson() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.androidbegin.com/").addConverterFactory(GsonConverterFactory.create()).build();
        CountryApi request=retrofit.create(CountryApi.class);
        Call<JsonResponse> call=request.getWorldCountries();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                countriesList = response.body();
                worldpopulation = countriesList.getWorldpopulation();
                worldCountriesAdapter = new WorldCountriesAdapter(getApplicationContext(), worldpopulation);
                countriesListView.setAdapter(worldCountriesAdapter);
                countriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Worldpopulation selectedWorldpopulation = worldpopulation.get(position);
                        Intent intent=new Intent(MainActivity.this,CountryDetails.class);
                        intent.putExtra("countryName", selectedWorldpopulation.getCountry());
                        intent.putExtra("countryRank", String.valueOf(selectedWorldpopulation.getRank()));
                        intent.putExtra("countryPopulation",selectedWorldpopulation.getPopulation());
                        intent.putExtra("countryFlag",selectedWorldpopulation.getFlag());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }
}
