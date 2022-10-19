package com.example.bulletinboard

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.bulletinboard.databinding.ActivityMainBinding
import com.example.bulletinboard.dialogs.DialogHelper
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
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
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_sign_out -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }

            R.id.id_sign_up -> {
                dialogHelper.createSignDialog(DialogHelper.SIGN_UP)
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }
}