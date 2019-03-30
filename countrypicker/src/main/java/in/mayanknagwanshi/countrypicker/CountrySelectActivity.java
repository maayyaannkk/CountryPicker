package in.mayanknagwanshi.countrypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.mayanknagwanshi.countrypicker.adapter.CountryAdapter;
import in.mayanknagwanshi.countrypicker.util.JsonHelper;

public class CountrySelectActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_select);

        recyclerView = findViewById(R.id.recyclerView);

        CountryAdapter countryAdapter = new CountryAdapter(JsonHelper.parseJsonToCountryList(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(countryAdapter);
    }


}
