package com.ads.myapplication.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ads.myapplication.R
import com.ads.myapplication.databinding.ActivityEditAdsBinding

class EditAdsAct : AppCompatActivity() {
  private lateinit var rootElement: ActivityEditAdsBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    rootElement = ActivityEditAdsBinding.inflate(layoutInflater)

    setContentView(rootElement.root)
  }
}