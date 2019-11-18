package com.diegomedina.notesapp.presentation.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.diegomedina.notesapp.R
import com.diegomedina.notesapp.presentation.view.home.peliculas.PeliculasFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        showFragment(PeliculasFragment(), PeliculasFragmentTag)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            removeActiveFragment()

            when (menuItem.itemId) {
                R.id.notes -> showFragment(PeliculasFragment(), PeliculasFragmentTag)
               // R.id.profile -> showFragment(ProfileFragment(), ProfileFragmentTag)
            }

            true
        }
    }

    private fun removeActiveFragment() {
        listOf(PeliculasFragmentTag, ProfileFragmentTag).forEach { tag ->
            val fragment = supportFragmentManager.findFragmentByTag(tag)
            fragment?.let {
                supportFragmentManager
                    .beginTransaction()
                    .remove(it)
                    .commit()
            }
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, fragment, tag)
            .commit()
    }

    companion object {
        private const val PeliculasFragmentTag = "PeliculasFragmentTag"
        private const val ProfileFragmentTag = "ProfileFragmentTag"
    }
}
