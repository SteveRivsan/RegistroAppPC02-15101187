package com.example.registroapppc02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()
        val tvNombre: TextView = findViewById(R.id.tvNombre)
        val tvAño: TextView = findViewById(R.id.tvAño)
        val tvTitulos: TextView = findViewById(R.id.tvTitulos)
        db.collection("Equipos")
            .addSnapshotListener{ snapshosts, e ->

                if(e!=null){
                    Snackbar
                        .make(
                            findViewById(android.R.id.content)
                            ,"Ocurrió un error al consultar la colección"
                            ,Snackbar.LENGTH_LONG
                        ).show()
                    return@addSnapshotListener
                }

                for(dc in snapshosts!!.documentChanges)
                {
                    when(dc.type){
                        DocumentChange.Type.ADDED, DocumentChange.Type.MODIFIED ->{
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content)
                                    ,"Se agregó un documento"
                                    ,Snackbar.LENGTH_LONG
                                ).show()
                            tvNombre.text = dc.document.data["Nombre"].toString()
                            tvAño.text = dc.document.data["AñoFundacion"].toString()
                            tvTitulos.text = dc.document.data["NumeroTitulos"].toString()

                        }
                        DocumentChange.Type.REMOVED -> {
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content)
                                    ,"Se eliminó el documento"
                                    ,Snackbar.LENGTH_LONG
                                ).show()
                        }
                        else -> {
                            Snackbar
                                .make(
                                    findViewById(android.R.id.content)
                                    ,"Error al consultar la colección"
                                    ,Snackbar.LENGTH_LONG
                                ).show()
                        }
                    }
                }
            }
    }
}

