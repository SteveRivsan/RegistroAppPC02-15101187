package com.example.registroapppc02.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registroapppc02.Modelos.Equipos
import com.example.registroapppc02.R
import com.google.firebase.firestore.FirebaseFirestore


class ListadoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_listado, container, false)

        val db = FirebaseFirestore.getInstance()
        var lstEquipos: List<Equipos>
        val rv: RecyclerView = view.findViewById(R.id.rv)

        db.collection("courses")
            .addSnapshotListener { snap, e ->
                if (e != null) {
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstEquipos = snap!!.documents.map { document ->
                    CourseModel(
                        document["description"].toString(),
                        document["score"].toString(), document["imageUrl"].toString()
                    )
                }

                rvCourse.adapter = CourseAdapter(lstCourses)
                rvCourse.layoutManager = LinearLayoutManager(requireContext())
            }
        return view
    }
}
