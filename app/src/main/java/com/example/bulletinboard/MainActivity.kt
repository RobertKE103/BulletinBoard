package com.example.bulletinboard

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.bulletinboard.databinding.ActivityMainBinding
import com.example.bulletinboard.dialogs.DialogHelper
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val tvAccount by lazy {
        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.usersEmail)
    }

    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }

    private fun init() {

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.mainContent.toolbar,
            R.string.open,
            R.string.close
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.id_ads -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_car -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_pc -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_smart -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_dm -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_sign_in -> {
                dialogHelper.createSignDialog(DialogHelper.SIGN_IN)
            }

            R.id.id_sign_out -> {
                uiUpdate(null)
                mAuth.signOut()
            }

            R.id.id_sign_up -> {
                dialogHelper.createSignDialog(DialogHelper.SIGN_UP)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun uiUpdate(user: FirebaseUser?){
        tvAccount.text = if (user == null) getString(R.string.not_reg) else user.email
    }
}