package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat // IMPORT NECESSÁRIO

class ResultActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        // Recupera o valor do IMC passado pela Intent
        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        // Obtém as referências dos TextViews
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        // Exibe o resultado do IMC
        tvResult.text = result.toString()

        // Define a classificação e a cor correspondente
        val (classificacao, cor) = when {
            result < 18.5f -> "MAGREZA" to R.color.magreza
            result in 18.5f..24.9f -> "NORMAL" to R.color.normal
            result in 25f..29.9f -> "SOBREPESO" to R.color.sobrepeso
            result in 30f..39.9f -> "OBESIDADE" to R.color.obesidade
            else -> "OBESIDADE GRAVE" to R.color.obesidade_grave
        }

        // Define a classificação no TextView
        tvClassificacao.text = classificacao

        // Aplica a cor correspondente ao TextView
        tvClassificacao.setTextColor(ContextCompat.getColor(this, cor)) // CORRIGIDO AQUI
    }
}
