package com.ads.myapplication.dialoghelper

import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import com.ads.myapplication.MainActivity
import com.ads.myapplication.R
import com.ads.myapplication.accounthelper.AccountHelper
import com.ads.myapplication.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
  private val activity = act
  private val accHelper = AccountHelper(activity)

  fun createSignDialog(index:Int) {
    val builder = AlertDialog.Builder(activity)
    val rootDialogElement = SignDialogBinding.inflate(activity.layoutInflater)
    val view = rootDialogElement.root

    builder.setView(view)

    setDialogState(index, rootDialogElement)

    val dialog = builder.create()

    rootDialogElement.btSignUpIn.setOnClickListener {
      setOnClickSignUpIn(index, rootDialogElement, dialog)
    }

    rootDialogElement.btForgetPass.setOnClickListener {
      setOnClickForgetPass(rootDialogElement, dialog)
    }

    dialog.show()
  }

  private fun setOnClickForgetPass(rootDialogElement: SignDialogBinding, dialog: AlertDialog?) {
    if (rootDialogElement.edSignEmail.text.isNotEmpty()) {
      activity.mAuth.sendPasswordResetEmail(rootDialogElement.edSignEmail.text.toString())
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            Toast.makeText(activity, R.string.email_reset_password_was_send, Toast.LENGTH_LONG).show()
          }
        }

      dialog?.dismiss()
    } else {
      rootDialogElement.tvDialogMessage.visibility = View.VISIBLE
    }
  }

  private fun setOnClickSignUpIn(index: Int, rootDialogElement: SignDialogBinding, dialog: AlertDialog?) {
    dialog?.dismiss()

    if (index == DialogConst.SIGN_UP_STATE) {
      accHelper.signUpWithEmail(
        rootDialogElement.edSignEmail.text.toString(),
        rootDialogElement.edSignPassword.text.toString()
      )
    } else {
      accHelper.signInWithEmail(
        rootDialogElement.edSignEmail.text.toString(),
        rootDialogElement.edSignPassword.text.toString()
      )
    }
  }

  private fun setDialogState(index: Int, rootDialogElement: SignDialogBinding) {
    if (index == DialogConst.SIGN_UP_STATE) {
      rootDialogElement.tvSingTitle.text = activity.resources.getString(R.string.ad_sign_up)
      rootDialogElement.btSignUpIn.text = activity.resources.getString(R.string.sign_up_action)
    } else {
      rootDialogElement.tvSingTitle.text = activity.resources.getString(R.string.ad_sign_in)
      rootDialogElement.btSignUpIn.text = activity.resources.getString(R.string.sign_in_action)
      rootDialogElement.btForgetPass.visibility = View.VISIBLE
    }
  }
}