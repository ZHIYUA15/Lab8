// CustomList.java
package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {
    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null && context != null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        if (view != null) {
            City city = cities.get(position);
            TextView cityName = view.findViewById(R.id.city_text);
            TextView provinceName = view.findViewById(R.id.province_text);

            cityName.setText(city.getCityName());
            provinceName.setText(city.getProvinceName());
        }

        return view != null ? view : new View(context);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    public void addCity(City city) {
        if (city != null) {
            cities.add(city);
            notifyDataSetChanged();
        }
    }

    public boolean hasCity(City city) {
        if (city == null) return false;
        for (City c : cities) {
            if (c.getCityName().equals(city.getCityName()) &&
                    c.getProvinceName().equals(city.getProvinceName())) {
                return true;
            }
        }
        return false;
    }

    public void deleteCity(City city) {
        if (city != null) {
            cities.removeIf(c ->
                    c.getCityName().equals(city.getCityName()) &&
                            c.getProvinceName().equals(city.getProvinceName())
            );
            notifyDataSetChanged();
        }
    }

    // Added for testing purposes
    protected ArrayList<City> getCities() {
        return cities;
    }
}