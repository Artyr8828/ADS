package com.ads.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.ads.myapplication.databinding.ActivityMainBinding
import com.ads.myapplication.dialoghelper.DialogConst
import com.ads.myapplication.dialoghelper.DialogHelper
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var rootElement:ActivityMainBinding
    private val dialogHelper = DialogHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rootElement = ActivityMainBinding.inflate(layoutInflater)

        val view = rootElement.root

        setContentView(view)
        init()
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(this, rootElement.dwLayout, rootElement.mainContent.toolbar, R.string.open, R.string.close)

        rootElement.dwLayout.addDrawerListener(toggle)

        toggle.syncState()

        rootElement.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.id_my_ads -> {
                Toast.makeText(this, "Presed id_my_ads", Toast.LENGTH_LONG).show()
            }
            R.id.id_car -> {

            }
            R.id.id_pc -> {

            }
            R.id.id_phone -> {

            }
            R.id.id_dm -> {

            }
            R.id.id_sign_up -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }
            R.id.id_sign_in -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }
            R.id.id_sign_out -> {

            }
        }

        rootElement.dwLayout.closeDrawer(GravityCompat.START)

        return true
    }
}