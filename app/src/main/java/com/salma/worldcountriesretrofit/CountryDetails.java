package com.salma.worldcountriesretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CountryDetails extends AppCompatActivity {
    ImageView countryFlag;
    TextView countryName;
    TextView countryRank;
    TextView countryPopulation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        countryName= findViewById(R.id.txtName);
        countryRank= findViewById(R.id.txtRank);
        countryPopulation=findViewById(R.id.txtPop);
        countryFlag=findViewById(R.id.imgFlag);
        Intent intent = getIntent();
        String countryNameValue = intent.getStringExtra("countryName");
        String countryRankValue=intent.getStringExtra("countryRank");
        String countryPopulationValue=intent.getStringExtra("countryPopulation");
        String countryFlagLink=intent.getStringExtra("countryFlag");
        countryName.setText(countryNameValue);
        countryRank.setText(countryRankValue);
        countryPopulation.setText(countryPopulationValue);
        Glide.with(this).load(countryFlagLink).onlyRetrieveFromCache(true).into(countryFlag);
    }
}
