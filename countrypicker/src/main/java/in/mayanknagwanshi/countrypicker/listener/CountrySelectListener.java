package in.mayanknagwanshi.countrypicker.listener;

import in.mayanknagwanshi.countrypicker.bean.CountryData;

@FunctionalInterface
public interface CountrySelectListener {
    void onCountrySelect(CountryData countryData);
}
