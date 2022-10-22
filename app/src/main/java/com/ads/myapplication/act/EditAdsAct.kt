package com.ads.myapplication.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ads.myapplication.R
import com.ads.myapplication.databinding.ActivityEditAdsBinding
import com.ads.myapplication.dialogs.DialogSpinnerHelper
import com.ads.myapplication.utils.CityHelper

class EditAdsAct : AppCompatActivity() {
  private lateinit var rootElement: ActivityEditAdsBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    rootElement = ActivityEditAdsBinding.inflate(layoutInflater)

    setContentView(rootElement.root)

    val listCountry =  CityHelper.getAllCountries(this)
    val dialog = DialogSpinnerHelper()

    dialog.showSpinnerDialog(this, listCountry)

  }
}