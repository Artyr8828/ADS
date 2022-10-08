package com.ads.myapplication.accounthelper

import android.widget.Toast
import com.ads.myapplication.MainActivity
import com.ads.myapplication.R
import com.google.firebase.auth.FirebaseUser

class AccountHelper(activity: MainActivity) {
  private val act= activity

  fun signUpWithEmail(email:String, password:String) {
    if(email.isNotEmpty() && password.isNotEmpty()) {
      act
        .mAuth
        .createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            sendEmailVerification(task.result?.user!!)
          } else {
            Toast.makeText(act, act.resources.getString(R.string.sign_up_error), Toast.LENGTH_LONG).show()
          }
        }
    }
  }

  private fun sendEmailVerification(user:FirebaseUser) {
    user.sendEmailVerification().addOnCompleteListener { task ->
      if (task.isSuccessful) {
        Toast.makeText(act, act.resources.getString(R.string.send_verif_email_done), Toast.LENGTH_LONG).show()
      } else {
        Toast.makeText(act, act.resources.getString(R.string.send_verif_email_error), Toast.LENGTH_LONG).show()
      }
    }
  }
}