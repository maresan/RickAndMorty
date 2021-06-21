package com.rickandmorty.rickandmorty.ui.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.ActivityLoginBinding
import com.rickandmorty.rickandmorty.ui.presentation.main.MainActivity

const val GOOGLE_SIGN_IN = 1000
private const val EMAIL = "email"
private const val USER_NAME = "user_name"
private const val PHOTO = "photo"

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (getSession()) {
            goToMainActivity()
        }

        binding.googleButton.setOnClickListener {
            loginWithGoogle()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun loginWithGoogle() {
        val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleClient = GoogleSignIn.getClient(this, googleConf)
        googleClient.signOut()

        startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                saveSession(account.email ?: "", account.displayName ?: "", account.photoUrl.toString())
                                goToMainActivity()
                            } else {
                                showError()
                            }
                        }
                }

            } catch (e: ApiException) {
                showError()
            }
        }
    }

    private fun getSession(): Boolean {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString(EMAIL, null)
        if (!email.isNullOrEmpty()) {
            return true
        }
        return false
    }

    private fun saveSession(email: String, userName: String, photo: String) {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString(USER_NAME, userName)
        prefs.putString(EMAIL, email)
        prefs.putString(PHOTO, photo)
        prefs.apply()
    }

    private fun showError(){
        Toast.makeText(this, getString(R.string.error_massage), Toast.LENGTH_LONG).show()
    }
}
