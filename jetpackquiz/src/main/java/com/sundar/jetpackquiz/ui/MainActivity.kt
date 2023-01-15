package com.sundar.jetpackquiz.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.sundar.jetpackquiz.R
import com.sundar.jetpackquiz.databinding.ActivityMainBinding
import com.sundar.jetpackquiz.ui.quiz.QuizViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val quizViewModel: QuizViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(this, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.onboardingFragment, R.id.splashFragment -> {
                    supportActionBar?.hide()
                    binding.toolbar.title = "Jetpack Android Quiz"
                }
                R.id.quizFragment -> {
                    //show menu
                    supportActionBar?.show()
                    binding.toolbar.menu[0].isVisible = true
                    invalidateOptionsMenu()
                    binding.toolbar.title = "Jetpack Android Quiz"
                }
                R.id.resultFragment -> {
                    invalidateOptionsMenu()
                    binding.toolbar.title = "Result"
                }
                R.id.resultAnalysisFragment -> {
                    binding.toolbar.title = "Result Analysis"
                }
                R.id.homeFragment -> {
                    supportActionBar?.show()
                    binding.toolbar.menu[0].isVisible = false
                    binding.toolbar.title = "Jetpack Android Quiz"
                }
                else -> {
                    binding.toolbar.title = ""
                }
            }
            supportActionBar?.setDisplayHomeAsUpEnabled(destination.id == R.id.resultAnalysisFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menu?.findItem(R.id.action_restart)?.isVisible =
            quizViewModel.currentQuestionNumber < quizViewModel.totalQuestionToAnswer
        return true
    }

    // menu click listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.action_restart -> {
                quizViewModel.resetQuiz()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}