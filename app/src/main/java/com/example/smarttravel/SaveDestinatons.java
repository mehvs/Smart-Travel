package com.example.smarttravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveDestinatons extends AppCompatActivity {

    List<Country> countries;
    RecyclerView recyclerView;
    NewCasesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_destinatons);

        TextView newCases = findViewById(R.id.new_cases_text);
        EditText searchEditText = findViewById(R.id.search);
        recyclerView = findViewById(R.id.cases_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(searchEditText.getText().toString());
                    return true;
                }
                return false;
            }
        });

        NetworkManager networkManager = new NetworkManager();
        networkManager.getCovidData(new Callback<World>() {
            @Override
            public void onResponse(Call<World> call, Response<World> response) {
                if (response.isSuccessful()) {
                    World world = response.body();
                    newCases.setText(world.getGlobalCases().getNewCases() + "");
                    countries = world.getCountries();
                    adapter = new NewCasesAdapter(countries);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<World> call, Throwable t) {

            }
        });
    }

    private void performSearch(String word) {
        if (countries == null) {
            return;
        }

        ArrayList<Country> filteredCountries = new ArrayList<>();
        for (Country country : countries) {
            if (country.getCountry().toLowerCase().contains(word.toLowerCase())) {
                filteredCountries.add(country);
            }
        }

        adapter.setData(filteredCountries);
        adapter.notifyDataSetChanged();
    }
}