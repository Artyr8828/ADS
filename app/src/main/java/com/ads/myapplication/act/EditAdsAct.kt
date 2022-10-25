package com.ads.myapplication.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
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

    dialog.showSpinnerDialog(this, listCountry)
  }
}