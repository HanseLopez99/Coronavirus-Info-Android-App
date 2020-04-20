package com.example.lopezhansel_lab3_appsmobiles

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView

class SecondActivity : AppCompatActivity() {
    private val topic: Topic = Topic("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent:Intent = Intent(this, MainActivity::class.java)

        val scrollResultado:TextView = findViewById(R.id.scroll_text)
        val titleText:TextView = findViewById(R.id.title)
        val editext:EditText = findViewById(R.id.coment_editText)
        val button:TextView = findViewById(R.id.comentar_button)

        button.setOnClickListener{
            if(editext.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo de comentarios esta vacio...", Toast.LENGTH_LONG).show()
            }else{
                intent.putExtra("comment",editext.getText().toString())
                startActivity(intent)
            }
        }

        scrollResultado.text = getIntent().getStringExtra("texto")
        titleText.text = getIntent().getStringExtra("title")
    }
}
