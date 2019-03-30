package in.mayanknagwanshi.countrypicker.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.mayanknagwanshi.countrypicker.R;
import in.mayanknagwanshi.countrypicker.bean.CountryData;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<CountryData> countryDataList;

    public CountryAdapter(ArrayList<CountryData> countryDataList) {
        this.countryDataList = countryDataList;
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView textViewCountryName, textViewCountryISD;
        ImageView imageViewFlag;

        CountryViewHolder(View v) {
            super(v);
            textViewCountryName = v.findViewById(R.id.textViewCountryName);
            textViewCountryISD = v.findViewById(R.id.textViewISDCode);
            imageViewFlag = v.findViewById(R.id.imageViewCountryFlag);
        }
    }

    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_country, parent, false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.textViewCountryName.setText(countryDataList.get(position).getCountryName());
        holder.textViewCountryISD.setText(countryDataList.get(position).getCountryISD());
        holder.imageViewFlag.setImageResource(countryDataList.get(position).getCountryFlag());
    }

    @Override
    public int getItemCount() {
        return countryDataList.size();
    }
}