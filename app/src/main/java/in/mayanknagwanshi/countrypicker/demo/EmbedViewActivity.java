package in.mayanknagwanshi.countrypicker.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.mayanknagwanshi.countrypicker.custom.CountryPickerView;

public class EmbedViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embed_view);

        CountryPickerView countryPickerView = findViewById(R.id.countryPickerView);
        countryPickerView.setCountrySelectListener(countryData -> {
            Toast.makeText(this, countryPickerView.getSelectedCountry().getCountryName(), Toast.LENGTH_SHORT).show();
        });
    }
}
