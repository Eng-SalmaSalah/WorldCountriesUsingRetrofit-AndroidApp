package com.salma.worldcountriesretrofit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class WorldCountriesAdapter extends ArrayAdapter {
    private List<Worldpopulation> _worldCountries;
    private Context _context;
    private int _resource;
    private static int _counter;

    public WorldCountriesAdapter(Context context, List<Worldpopulation> worldCountries) {
        super(context, R.layout.singlerow, R.id.Txt_countryName, worldCountries);
        _worldCountries = worldCountries;
        _context = context;
        _resource = R.layout.singlerow;
        _counter = 0;
    }


    @Override
    public View getView(int position, View currentView, ViewGroup listView) {
        ViewHolder viewHolder;
        View row = currentView;
        if (row == null) {
            _counter++;
            LayoutInflater layoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(_resource, listView, false);
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
            Log.i("counter", Integer.toString(_counter));
        } else {
            viewHolder = (ViewHolder) row.getTag();
            Log.i("counter", "rows recycled");
        }
        ImageView countryFlag = viewHolder.getCountryFlag();
        TextView countryName = viewHolder.getCountryName();
        TextView countryPopulation = viewHolder.getCountryPopulation();
        TextView countryRank = viewHolder.getCountryRank();

        String imageLink = _worldCountries.get(position).getFlag();
        Glide.with(_context).load(imageLink).diskCacheStrategy(DiskCacheStrategy.ALL).into(countryFlag);
        //diskCache(3lshan lma aafl l app w aft7o yfdl 3aml caching) f b3ml diskCacheStrategy(DiskCacheStrategy.ALL)
        // memoryCache(3lshan y3ml caching tol ma l app sh8al) da by7sl by default
        countryName.setText(_worldCountries.get(position).getCountry());
        countryPopulation.setText(_worldCountries.get(position).getPopulation());
        countryRank.setText(String.valueOf(_worldCountries.get(position).getRank()));
        return row;
    }
}
