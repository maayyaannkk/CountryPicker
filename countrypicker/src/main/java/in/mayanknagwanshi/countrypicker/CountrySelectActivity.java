package in.mayanknagwanshi.countrypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import in.mayanknagwanshi.countrypicker.adapter.CountryAdapter;
import in.mayanknagwanshi.countrypicker.bean.CountryData;
import in.mayanknagwanshi.countrypicker.util.JsonHelper;

public class CountrySelectActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText editTextSearch;
    CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_select);

        recyclerView = findViewById(R.id.recyclerView);
        editTextSearch = findViewById(R.id.editTextSearch);

        countryAdapter = new CountryAdapter(JsonHelper.parseJsonToCountryList(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(countryAdapter);

        countryAdapter.setCountrySelectListener(new CountryAdapter.CountrySelectListener() {
            @Override
            public void onCountrySelect(CountryData countryData) {
                Toast.makeText(CountrySelectActivity.this, countryData.getCountryName(), Toast.LENGTH_SHORT).show();
                //TODO send result back to calling activity
            }
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            //region not used

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //endregion
            @Override
            public void afterTextChanged(Editable s) {
                String searchString = s.toString();
                countryAdapter.setCountryDataList(JsonHelper.parseJsonToCountryList(CountrySelectActivity.this, searchString));
            }
        });
    }


}
