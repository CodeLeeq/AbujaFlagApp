package com.itsmaleeq.abujaflag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var newsFragment: NewsFragment
    lateinit var videosFragment: VideosFragment
    lateinit var photosFragment: PhotosFragment
    lateinit var teamFragment: TeamFragment
    lateinit var gameDayFragment: GameDayFragment
    lateinit var shopFragment: ShopFragment
    lateinit var logOutFragment: LogOutFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            (R.string.open),
            (R.string.close)
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        //for now the default fragment is news fragment
        newsFragment = NewsFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, newsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        //Creating a related fragments
        when (menuItem.itemId) {
            R.id.news -> {
                newsFragment = NewsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, newsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.videos -> {
                videosFragment = VideosFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, videosFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.photos -> {
                photosFragment = PhotosFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, photosFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.team -> {
                teamFragment = TeamFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, teamFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.gameday -> {
                gameDayFragment = GameDayFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, gameDayFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.videos -> {
                shopFragment = ShopFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, shopFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.logout -> {
                logOutFragment = LogOutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, logOutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }


    }
}
