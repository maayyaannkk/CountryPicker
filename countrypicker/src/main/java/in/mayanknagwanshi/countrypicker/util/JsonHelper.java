package in.mayanknagwanshi.countrypicker.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import in.mayanknagwanshi.countrypicker.R;
import in.mayanknagwanshi.countrypicker.bean.CountryData;

public class JsonHelper {
    public static ArrayList<CountryData> parseJsonToCountryList(Context context) {
        try {
            JSONObject mainObject = new JSONObject(getJson(context));
            JSONArray countryArray = mainObject.getJSONArray("countryCodes");
            ArrayList<CountryData> countryDataArrayList = new ArrayList<>();
            for (int i = 0; i < countryArray.length(); i++) {
                JSONObject countryObject = countryArray.getJSONObject(i);
                CountryData countryData = new CountryData();
                countryData.setCountryCode(countryObject.getString("country_code"));
                countryData.setCountryName(countryObject.getString("country_name"));
                countryData.setCountryISD(countryObject.getString("dialling_code"));
                countryData.setCountryFlag(context.getResources().getIdentifier(countryObject.getString("country_flag"), "drawable", context.getPackageName()));
                countryDataArrayList.add(countryData);
            }
            return countryDataArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<CountryData> parseJsonToCountryList(Context context, String searchString) {
        try {
            JSONObject mainObject = new JSONObject(getJson(context));
            JSONArray countryArray = mainObject.getJSONArray("countryCodes");
            ArrayList<CountryData> countryDataArrayList = new ArrayList<>();
            for (int i = 0; i < countryArray.length(); i++) {
                JSONObject countryObject = countryArray.getJSONObject(i);
                CountryData countryData = new CountryData();
                countryData.setCountryCode(countryObject.getString("country_code"));
                countryData.setCountryName(countryObject.getString("country_name"));
                countryData.setCountryISD(countryObject.getString("dialling_code"));
                countryData.setCountryFlag(context.getResources().getIdentifier(countryObject.getString("country_flag"), "drawable", context.getPackageName()));
                if (countryData.getCountryName().toLowerCase().contains(searchString.toLowerCase())
                        || countryData.getCountryCode().toLowerCase().contains(searchString.toLowerCase())
                        || countryData.getCountryISD().toLowerCase().contains(searchString.toLowerCase()))
                    countryDataArrayList.add(countryData);
            }
            return countryDataArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getJson(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.country);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
            return writer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
