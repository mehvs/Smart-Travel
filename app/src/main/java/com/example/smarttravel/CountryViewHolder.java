package com.example.smarttravel;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    TextView countryTextView;
    TextView countTextView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);

        countryTextView = itemView.findViewById(R.id.country_name);
        countTextView = itemView.findViewById(R.id.new_cases_count);
    }

    public void bind(Country country) {
        countryTextView.setText(country.getCountry());
        int newCases = country.getNewCases();
        countTextView.setText(newCases + "");
        countTextView.setTextColor(newCases > 100 ? Color.RED : Color.GREEN);

    }
}
