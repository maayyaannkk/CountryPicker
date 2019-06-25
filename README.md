# Country-Picker
Android library to get country data (eg. ISD code, country code, name) from list of countries.

# Download [![](https://jitpack.io/v/maayyaannkk/CountryPicker.svg)](https://jitpack.io/#maayyaannkk/CountryPicker) [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-CountryPicker-green.svg?style=flat )]( https://android-arsenal.com/details/1/7717 )

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
Embed layout in xml like
```xml
<in.mayanknagwanshi.countrypicker.custom.CountryPickerView
        android:id="@+id/countryPickerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:showSearch="true" /><!-- false to hide search edit text -->
```
and reference in activity/fragment to get selection
```java
CountryPickerView countryPickerView = findViewById(R.id.countryPickerView);
countryPickerView.setCountrySelectListener(countryData -> {
	//country details
	String countryName = countryData.getCountryName();
        String isdCode = countryData.getCountryISD();
        String countryCode = countryData.getCountryCode();
});
```
OR
```java
countryPickerView.getSelectedCountry(); //returns null if nothing was selected
```

Option to start the activity as dialog
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
        }
    }
```
