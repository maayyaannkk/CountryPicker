package in.mayanknagwanshi.countrypicker.bean;

import java.io.Serializable;

public class CountryData implements Serializable {
    private String countryName, countryCode, countryISD;
    private int countryFlag;
    //boolean isSelected;

    public CountryData() {}

    public CountryData(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryISD() {
        return countryISD;
    }

    public void setCountryISD(String countryISD) {
        this.countryISD = countryISD;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }

    public boolean equals(CountryData countryData) {
        return countryCode.equalsIgnoreCase(countryData.getCountryCode());
    }
}
