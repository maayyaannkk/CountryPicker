package in.mayanknagwanshi.countrypicker.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import in.mayanknagwanshi.countrypicker.R;
import in.mayanknagwanshi.countrypicker.adapter.CountryAdapter;
import in.mayanknagwanshi.countrypicker.bean.CountryData;
import in.mayanknagwanshi.countrypicker.listener.CountrySelectListener;
import in.mayanknagwanshi.countrypicker.util.JsonHelper;

public class CountryPickerView extends LinearLayout {
    CountryAdapter countryAdapter;
    private boolean showSearch;
    private CountrySelectListener countrySelectListener;

    public CountryPickerView(Context context) {
        this(context, null);
    }

    public CountryPickerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public CountryPickerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CountryPickerView);
        showSearch = a.getBoolean(R.styleable.CountryPickerView_showSearch, true);
        a.recycle();
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CountryPickerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CountryPickerView);
        showSearch = a.getBoolean(R.styleable.CountryPickerView_showSearch, true);
        a.recycle();
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.compound_country_select, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText editText = findViewById(R.id.editTextSearch);

        countryAdapter = new CountryAdapter(JsonHelper.parseJsonToCountryList(this.getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(countryAdapter);

        if (!showSearch) {
            editText.setVisibility(GONE);
        }else {
            editText.addTextChangedListener(new TextWatcher() {
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
                    countryAdapter.setCountryDataList(JsonHelper.parseJsonToCountryList(CountryPickerView.this.getContext(), searchString));
                }
            });
        }

        countryAdapter.setCountrySelectListener(new CountrySelectListener() {
            @Override
            public void onCountrySelect(CountryData countryData) {
                if (countrySelectListener != null)
                    countrySelectListener.onCountrySelect(countryData);
            }
        });
    }

    public void setCountrySelectListener(CountrySelectListener countrySelectListener) {
        this.countrySelectListener = countrySelectListener;
    }
}
