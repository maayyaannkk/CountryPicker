# Country-Picker
Android library to get country data (eg. ISD code, country code, name) from list of countries.

# Download [![](https://jitpack.io/v/maayyaannkk/CountryPicker.svg)](https://jitpack.io/#maayyaannkk/CountryPicker)

Add this to your project's `build.gradle`

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

And add this to your module's `build.gradle` 

```groovy
dependencies {
	implementation 'com.github.maayyaannkk:CountryPicker:x.y.z'
}
```

change `x.y.z` to version in [![](https://jitpack.io/v/maayyaannkk/CountryPicker.svg)](https://jitpack.io/#maayyaannkk/CountryPicker)

## Usage
The simplest way to start is start the activity
```java
Intent intent = new Intent(this, CountrySelectActivity.class);
startActivityForResult(intent, 1213);
```
Receive result
```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
            CountryData countryData = (CountryData) data.getSerializableExtra(CountrySelectActivity.RESULT_COUNTRY_DATA);
            //country details
            String countryName = countryData.getCountryName();
            String isdCode = countryData.getCountryISD();
            String countryCode = countryData.getCountryCode();
        }
    }
```
