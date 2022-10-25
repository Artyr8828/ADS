package com.ads.myapplication.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.ads.myapplication.R
import com.ads.myapplication.databinding.ActivityEditAdsBinding
import com.ads.myapplication.dialogs.DialogSpinnerHelper
import com.ads.myapplication.utils.CityHelper

class EditAdsAct : AppCompatActivity() {
  lateinit var rootElement: ActivityEditAdsBinding
  private var dialog = DialogSpinnerHelper()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    rootElement = ActivityEditAdsBinding.inflate(layoutInflater)

    setContentView(rootElement.root)

    init()
  }

  private fun init() {}

  fun onClickSelectCountry(view: View) {
    val listCountry =  CityHelper.getAllCountries(this)

    dialog.showSpinnerDialog(this, listCountry, rootElement.tvCountry)

    if (rootElement.tvCity.text.toString() != getString(R.string.select_city)) {
      rootElement.tvCity.text = getString(R.string.select_city)
    }
  }

  fun onClickSelectCity(view: View) {
    val selectedCountry = rootElement.tvCountry.text.toString()

    if (selectedCountry != getString(R.string.select_country)) {
      val listCity =  CityHelper.getAllCities(selectedCountry,this)

      dialog.showSpinnerDialog(this, listCity, rootElement.tvCity)
    } else {
      Toast.makeText(this, "Выберете страну", Toast.LENGTH_LONG).show()
    }

  }
}