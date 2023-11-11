package com.example.registroapppc02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val txtNomEqui: EditText = findViewById(R.id.txtNomEqui)
        val txtAño: EditText = findViewById(R.id.txtAño)
        val txtTitulos: EditText = findViewById(R.id.txtTitulos)
        val txtURL: EditText = findViewById(R.id.txtURL)
        val btnSave: Button = findViewById(R.id.btnSave)
        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("Equipos")

        btnSave.setOnClickListener {
            val NombreEquipo = txtNomEqui.text.toString()
            val Año = txtAño.text.toString()
            val Titulos = txtTitulos.text.toString()
            val URL = txtURL.text.toString()
        }
    }
}