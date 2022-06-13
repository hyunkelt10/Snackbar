package com.example.toast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun normal(view: View){
        Toast.makeText(this, "toast normal", Toast.LENGTH_SHORT).show()
    }

    fun gravity(view: View) {
        val t = Toast.makeText(this, "gravity izquierda",Toast.LENGTH_SHORT)
        t.setGravity(Gravity.CENTER,0,0)
        t.show()

    }

    fun layout (view: View) {
        val layout = layoutInflater.inflate(R.layout.toast_layout,null)
        layout!!.findViewById<TextView>(R.id.tvTitulo).text = "prueba de layout titulo"
        layout!!.findViewById<TextView>(R.id.tvDescripcion).text = "prueba de layout  descripcion"
        val t = Toast(this@MainActivity)
        t.duration = Toast.LENGTH_SHORT
        t.view = layout
        t.show()

    }

    fun Snackbar(view:View) {
        Snackbar.make(view, "Test", Snackbar.LENGTH_SHORT).show()
    }

    fun SnackbarColor(view:View) {
        val s = Snackbar.make(view, "Test Color", Snackbar.LENGTH_SHORT)
        s.setTextColor(ContextCompat.getColor(view.context, R.color.purple_500))
        s.setActionTextColor(ContextCompat.getColor(view.context, R.color.black))
        s.setBackgroundTint(Color.BLUE)
        s.show()







    }
    fun SnackbarCustom(view: View) {
        val s = Snackbar.make(view,"custom", Snackbar.LENGTH_SHORT)
        val sblayout = s.view as Snackbar.SnackbarLayout
        val customLayout = layoutInflater.inflate(R.layout.toast_layout, null)

        customLayout!!.findViewById<TextView>(R.id.tvTitulo).text = "alerta de titulo"
        customLayout!!.findViewById<TextView>(R.id.tvDescripcion).text = "Descripcion personalizada"
        sblayout.addView(customLayout, 0)
        s.setBackgroundTint(Color.GREEN)
        s.show()





    }

}

