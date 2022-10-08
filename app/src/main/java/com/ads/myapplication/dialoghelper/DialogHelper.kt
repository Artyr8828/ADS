package com.ads.myapplication.dialoghelper

import android.app.AlertDialog
import com.ads.myapplication.MainActivity
import com.ads.myapplication.R
import com.ads.myapplication.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
  private val activity = act

  fun createSignDialog(index:Int) {
    val builder = AlertDialog.Builder(activity)
    val rootDialogElement = SignDialogBinding.inflate(activity.layoutInflater)
    val view = rootDialogElement.root

    if (index == DialogConst.SIGN_UP_STATE) {
      rootDialogElement.tvSingTitle.text = activity.resources.getString(R.string.ad_sign_up)
      rootDialogElement.btSignUpIn.text = activity.resources.getString(R.string.sign_up_action)
    } else {
      rootDialogElement.tvSingTitle.text = activity.resources.getString(R.string.ad_sign_in)
      rootDialogElement.btSignUpIn.text = activity.resources.getString(R.string.sign_in_action)
    }

    builder.setView(view)
    builder.show()
  }
}