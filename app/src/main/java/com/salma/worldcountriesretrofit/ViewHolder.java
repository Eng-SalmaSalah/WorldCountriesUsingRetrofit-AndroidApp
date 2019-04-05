package com.salma.worldcountriesretrofit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private View currentView;
    private ImageView countryFlag;
    private TextView countryName;
    private TextView countryPopulation;
    private TextView countryRank;

    public ViewHolder(View currentView) {
        this.currentView = currentView;
    }

    public ImageView getCountryFlag(){
        if(countryFlag==null)
            countryFlag=currentView.findViewById(R.id.img_flag);
        return countryFlag;
    }

    public TextView getCountryName(){
        if(countryName==null)
            countryName=currentView.findViewById(R.id.Txt_countryName);
        return countryName;
    }

    public TextView getCountryPopulation(){
        if(countryPopulation==null)
            countryPopulation=currentView.findViewById(R.id.txt_population);
        return countryPopulation;
    }

    public TextView getCountryRank(){
        if(countryRank==null)
            countryRank=currentView.findViewById(R.id.txt_rank);
        return countryRank;
    }
}
