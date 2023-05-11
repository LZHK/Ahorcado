package com.example.ahorcado

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var edtLetra: EditText
    lateinit var btnVerificar: Button
    lateinit var btnLimpiar: Button
    lateinit var tvLetra1: TextView
    lateinit var tvLetra2: TextView
    lateinit var tvLetra3: TextView
    lateinit var tvLetra4: TextView
    lateinit var tvAhorcado: TextView
    lateinit var tvResultado: TextView

    var intentos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLetra = findViewById(R.id.edtLetra)

        btnVerificar = findViewById(R.id.btnVerificar)
        btnLimpiar = findViewById(R.id.btnLimpiar)

        tvLetra1 = findViewById(R.id.tvLetra1)
        tvLetra2 = findViewById(R.id.tvLetra2)
        tvLetra3 = findViewById(R.id.tvLetra3)
        tvLetra4 = findViewById(R.id.tvLetra4)

        tvAhorcado = findViewById(R.id.tvAhorcado)
        tvResultado = findViewById(R.id.tvResultado)

        //Funcionamiento de los botones
        btnVerificar.setOnClickListener {
            if(!edtLetra.text.toString().isEmpty()){
                val letraIngresada = edtLetra.text.toString().trim().toUpperCase()
                if (letraIngresada == "g" || letraIngresada == "G"){
                    tvLetra1.text = "G"
                }else if (letraIngresada == "a" || letraIngresada == "A"){
                    tvLetra2.text = "A"
                }else if (letraIngresada == "t" || letraIngresada == "T"){
                    tvLetra3.text = "T"
                }else if (letraIngresada == "o" || letraIngresada == "O"){
                    tvLetra4.text = "O"
                }else {
                    intentos ++
                }

                when (intentos){
                    1 -> tvAhorcado.text = "A"
                    2 -> tvAhorcado.text = "AH"
                    3 -> tvAhorcado.text = "AHO"
                    4 -> tvAhorcado.text = "AHOR"
                    5 -> tvAhorcado.text = "AHORC"
                    6 -> tvAhorcado.text = "AHORCA"
                    7 -> tvAhorcado.text = "AHORCAD"
                    8 -> tvAhorcado.text = "AHORCADO"
                }

                if (intentos >= 8){
                    tvResultado.text = "PERDISTE"
                    tvResultado.setTextColor(Color.RED)
                    btnVerificar.setBackgroundColor(ContextCompat.getColor(this,R.color.gris))
                    btnVerificar.isEnabled = false
                }

                if (!tvLetra1.text.toString().trim().isEmpty()&&
                        !tvLetra2.text.toString().trim().isEmpty()&&
                        !tvLetra3.text.toString().trim().isEmpty()&&
                        !tvLetra4.text.toString().trim().isEmpty()
                ){
                    tvResultado.text = "GANASTE"
                    tvResultado.setTextColor(Color.BLACK)
                    btnVerificar.setBackgroundColor(ContextCompat.getColor(this,R.color.gris))
                    btnVerificar.isEnabled = false
                }
                edtLetra.setText("")
            }
        }

        btnLimpiar.setOnClickListener {
            edtLetra.setText("")
            tvLetra1.setText("")
            tvLetra2.setText("")
            tvLetra3.setText("")
            tvLetra4.setText("")
            tvAhorcado.setText("")
            tvResultado.setText("")
            intentos = 0
            btnVerificar.isEnabled = true
            btnVerificar.setBackgroundColor(ContextCompat.getColor(this,R.color.verde))
        }
    }
}