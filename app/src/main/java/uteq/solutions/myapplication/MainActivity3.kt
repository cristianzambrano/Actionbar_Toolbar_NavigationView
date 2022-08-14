package uteq.solutions.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity3 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    var  toolbar: Toolbar? = null

    lateinit var navView: NavigationView
    lateinit var menu: Menu
    lateinit var fragment: Fragment1
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        toolbar = findViewById<Toolbar>(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout2)
        navView = findViewById(R.id.nav_view2)

        toolbar!!.title="App UTEQ"
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.iconmenu)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener(this);
        menu = navView.getMenu() //el Menú del NavView está vacío
        crearMenuDinamico()

        fragment = Fragment1()
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.content_frame2, fragment)
            .addToBackStack(null)
            .commit()


    }

    fun crearMenuDinamico(){

        for(i in 1..10){
            val newItem:MenuItem = menu.add( Menu.NONE, i, i, "Item ID: " +  i)
            newItem.setIcon(R.drawable.iconmenu)
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        fragment.setContent("Contenido del Item " + item.itemId)
        item.setChecked(true)
        getSupportActionBar()?.setTitle(item.getTitle());
        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }
}