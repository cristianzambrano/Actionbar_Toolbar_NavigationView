package uteq.solutions.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null
    var  toolbar: Toolbar? = null

    lateinit var navView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        toolbar = findViewById<Toolbar>(R.id.toolbar);
        toolbar!!.title="App UTEQ"
        setSupportActionBar(toolbar);

        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.iconmenu)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this);


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
             android.R.id.home -> {
                drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
                drawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.menu_seccion_1 -> {
                fragment = Fragment1()
            }
            R.id.menu_seccion_2 -> {
                fragment = Fragment2()
            }
            R.id.menu_seccion_3 -> {
                fragment = Fragment3()
            }
        }

        if (fragment != null) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit()

            item.setChecked(true)
            getSupportActionBar()?.setTitle(item.getTitle());
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }
}

