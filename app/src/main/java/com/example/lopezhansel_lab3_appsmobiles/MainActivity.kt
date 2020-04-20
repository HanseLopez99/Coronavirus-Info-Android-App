package com.example.lopezhansel_lab3_appsmobiles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.lopezhansel_lab3_appsmobiles.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var resultado:String

        binding.starButton.setOnClickListener{
            if(binding.nameEditText.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo nombre esta vacio...", Toast.LENGTH_LONG).show()
            }else if(binding.edadEditText.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo edad esta vacio...", Toast.LENGTH_LONG).show()
            }else{
                showText(it)
            }
        }
        binding.virusButton.setOnClickListener{
            val intent:Intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.sintomasButton.setOnClickListener{
            val intent:Intent = Intent(this, SecondActivity::class.java)
            resultado = "Segun tu peso: "
            intent.putExtra("texto",resultado)
            startActivity(intent)
        }

        binding.indicacionesButton.setOnClickListener{
            val intent:Intent = Intent(this, SecondActivity::class.java)
            resultado = "Segun tu peso: "
            intent.putExtra("texto",resultado)
            startActivity(intent)
        }
    }

    private fun showText(view: View){
        if(binding.edadEditText.text.toString().toInt() < 20){
            binding.riesgoText.text = "Segun tu rango de edad, estas en bajo riesgo si contraes el virus. (Edad entre 0 a 20)"
        }else if((binding.edadEditText.text.toString().toInt() > 20) && (binding.edadEditText.text.toString().toInt() < 45)) {
            binding.riesgoText.text =
                "Segun tu rango de edad, estas en riesgo alto si contraes el virus. (Edad entre 21 a 44)"
        }else{
            binding.riesgoText.text = "Segun tu rango de edad, estas en riesgo critico si contraes el virus. (Edad de 45 en adelante)"
        }

        binding.apply{
            invalidateAll()
            nameText.text = nameEditText.getText().toString()
            nameEditText.visibility = View.GONE
            edadText.visibility = View.GONE
            edadEditText.visibility = View.GONE
            riesgo_text.visibility = View.VISIBLE
        }

        val imm  = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
