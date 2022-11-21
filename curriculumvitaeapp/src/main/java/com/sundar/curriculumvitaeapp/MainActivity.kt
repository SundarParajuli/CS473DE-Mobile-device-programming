package com.sundar.curriculumvitaeapp


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.sundar.curriculumvitaeapp.databinding.ActivityMainBinding
import com.sundar.curriculumvitaeapp.ui.main.nav.contact.ContactFragmentDirections
import com.sundar.curriculumvitaeapp.ui.main.nav.home.HomeFragmentDirections
import com.sundar.curriculumvitaeapp.ui.main.nav.profile.ProfileFragmentDirections
import com.sundar.curriculumvitaeapp.ui.main.nav.work.WorkFragmentDirections


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onStart() {
        super.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavView()
    }

    private fun initBottomNavView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView: BottomNavigationView = binding.bottomNavView
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> {
                navController.navigate(HomeFragmentDirections.actionHome())
                binding.tvTitle.text = "Home"
            }
            R.id.item_about -> {
                navController.navigate(ProfileFragmentDirections.actionProfile())
                binding.tvTitle.text = "Profile"
            }
            R.id.item_work -> {
                navController.navigate(WorkFragmentDirections.actionWork())
                binding.tvTitle.text = "Work"
            }
            R.id.item_contact -> {
                navController.navigate(ContactFragmentDirections.actionContact())
                binding.tvTitle.text = "Contact"
            }
        }
        binding.fabAction.setImageDrawable(ResourcesCompat.getDrawable(resources,R.drawable.ic_baseline_create_24,null) )

        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (navController.currentBackStackEntry?.destination?.label == "fragment_login") {
            finishAffinity()
        }
    }


}