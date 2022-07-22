package uteq.solutions.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var txtMensaje: TextView? = null
    var  toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar);
        toolbar!!.title="App UTEQ"
        setSupportActionBar(toolbar);
        
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menutoolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun onClick(view: View) {
    Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnuBuscar -> {
                txtMensaje?.setText("Buscar");
                return true
            }
           R.id.mnuNuevo -> {
                txtMensaje?.setText("Nuevo");
                return true
            }
            R.id.mnuSettings -> {
                txtMensaje?.setText("Settings");
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}