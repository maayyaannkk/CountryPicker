package in.mayanknagwanshi.countrypicker.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.mayanknagwanshi.countrypicker.CountrySelectActivity;
import in.mayanknagwanshi.countrypicker.bean.CountryData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(v -> {
            Intent intent = new Intent(this, CountrySelectActivity.class);
            intent.putExtra(CountrySelectActivity.EXTRA_SELECTED_COUNTRY, new CountryData("IN"));
            startActivityForResult(intent, 121);
        });
        findViewById(R.id.button2).setOnClickListener(v -> {
            startActivity(new Intent(this, EmbedViewActivity.class));
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        if (requestCode == 121 && resultCode == RESULT_OK && data.hasExtra(CountrySelectActivity.RESULT_COUNTRY_DATA)) {
            CountryData countryData = (CountryData) data.getSerializableExtra(CountrySelectActivity.RESULT_COUNTRY_DATA);
            Toast.makeText(this, countryData.getCountryName(), Toast.LENGTH_SHORT).show();
        }
    }
}
