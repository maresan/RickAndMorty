package com.rickandmorty.rickandmorty.ui.presentation.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.FragmentProfileBinding
import com.rickandmorty.rickandmorty.ui.presentation.Login
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

private const val EMAIL = "email"
private const val USER_NAME = "user_name"
private const val PHOTO = "photo"

class FragmentProfile : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        binding.signOff.setOnClickListener {
            signOut(view)
        }
    }

    private fun initView(view: View){
        val prefs = view.context.getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        binding.userName.text = prefs.getString(USER_NAME, "")
        binding.email.text = prefs.getString(EMAIL, "")
        Picasso.get().load(prefs.getString(PHOTO, "")).transform(CropCircleTransformation()).into(binding.profilePhoto)
    }

    private fun signOut(view: View) {
        val prefs =
            view.context.getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
                .edit()
        prefs.clear()
        prefs.apply()
        goToLogin()
    }

    private fun goToLogin() {
        val intent = Intent(context, Login::class.java)
        activity?.finish()
        startActivity(intent)
    }
}
