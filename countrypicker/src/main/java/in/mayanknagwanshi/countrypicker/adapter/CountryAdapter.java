package in.mayanknagwanshi.countrypicker.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.mayanknagwanshi.countrypicker.R;
import in.mayanknagwanshi.countrypicker.bean.CountryData;
import in.mayanknagwanshi.countrypicker.listener.CountrySelectListener;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<CountryData> countryDataList;
    private CountrySelectListener countrySelectListener;
    private CountryData selectedCountry;

    public CountryAdapter(ArrayList<CountryData> countryDataList) {
        this.countryDataList = countryDataList;
    }

    public void setCountryDataList(ArrayList<CountryData> countryDataList) {
        this.countryDataList = countryDataList;
        notifyDataSetChanged();
    }

    public void setSelectedCountry(CountryData selectedCountry) {
        this.selectedCountry = selectedCountry;
        notifyDataSetChanged();
    }

    public void setCountrySelectListener(CountrySelectListener countrySelectListener) {
        this.countrySelectListener = countrySelectListener;
    }

    public CountryData getSelectedCountry() {
        return selectedCountry;
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
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
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_country, parent, false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CountryViewHolder holder, int position) {
        holder.textViewCountryName.setText(countryDataList.get(position).getCountryName());
        holder.textViewCountryISD.setText(countryDataList.get(position).getCountryISD());
        holder.imageViewFlag.setImageResource(countryDataList.get(position).getCountryFlag());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countrySelectListener.onCountrySelect(countryDataList.get(holder.getAdapterPosition()));
            }
        });
        if (selectedCountry != null) {
            if (countryDataList.get(position).equals(selectedCountry))
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorSelected));
            else
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorUnSelected));
        } else
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorUnSelected));

    }

    @Override
    public int getItemCount() {
        return countryDataList.size();
    }
}