package com.ads.myapplication.accounthelper

import android.util.Log
import android.widget.Toast
import com.ads.myapplication.MainActivity
import com.ads.myapplication.R
import com.ads.myapplication.constants.FirebaseAuthConst
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser

class AccountHelper(activity: MainActivity) {
  private val act= activity
  //  private lateinit var signInClient: GoogleSignInClient
  //  val signInRequestCode = 132

  fun signUpWithEmail(email:String, password:String) {
    if(email.isNotEmpty() && password.isNotEmpty()) {
      act
        .mAuth
        .createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            sendEmailVerification(task.result?.user!!)
            act.uiUpdate(task.result?.user)
          } else {
            if (task.exception is FirebaseAuthUserCollisionException) {
              val exception = task.exception as FirebaseAuthUserCollisionException

              if (exception.errorCode == FirebaseAuthConst.ERROR_EMAIL_ALREADY_IN_USE) {
                Toast.makeText(act, FirebaseAuthConst.ERROR_EMAIL_ALREADY_IN_USE, Toast.LENGTH_LONG).show()
              }
            }
            if (task.exception is FirebaseAuthInvalidCredentialsException) {
              val exception = task.exception as FirebaseAuthInvalidCredentialsException

              if (exception.errorCode == FirebaseAuthConst.ERROR_INVALID_EMAIL) {
                Toast.makeText(act, FirebaseAuthConst.ERROR_INVALID_EMAIL, Toast.LENGTH_LONG).show()
              }
            }
          }
        }
    }
  }

  fun signInWithEmail(email:String, password:String) {
    if(email.isNotEmpty() && password.isNotEmpty()) {
      act
        .mAuth
        .signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            act.uiUpdate(task.result?.user)
          } else {
            if (task.exception is FirebaseAuthInvalidCredentialsException) {
              val exception = task.exception as FirebaseAuthInvalidCredentialsException

              if (exception.errorCode == FirebaseAuthConst.ERROR_INVALID_EMAIL) {
                Toast.makeText(act, FirebaseAuthConst.ERROR_INVALID_EMAIL, Toast.LENGTH_LONG).show()
              }
            }
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
  // Авторизация по гугл аккаунту === НАЧАЛО ===
//  private fun getSignInClient():GoogleSignInClient {
//    // ключ взял из файла google-services.json, параметр client_id
//    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//      .requestIdToken("467669540737-e676s44lb2qckbhdebh42o3694mvn7ev.apps.googleusercontent.com")
//      .requestEmail()
//      .build()
//
//    return GoogleSignIn.getClient(act, gso)
//  }
//  fun signInWithGoogle() {
//    signInClient = getSignInClient()
//
//    val intent = signInClient.signInIntent
//
//    act.startActivityForResult(intent, signInRequestCode)
//  }
  // Авторизация по гугл аккаунту === КОНЕЦ ===
}















