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
import com.example.lopezhansel_lab3_appsmobiles.databinding.ActivitySecondBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val intent:Intent = Intent(this, SecondActivity::class.java)
        var resultado:String
        var key = false

        Toast.makeText(this, getIntent().getStringExtra("comment"), Toast.LENGTH_LONG).show()

        binding.starButton.setOnClickListener{
            if(binding.nameEditText.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo nombre esta vacio...", Toast.LENGTH_LONG).show()
            }else if(binding.edadEditText.getText().toString().isEmpty()) {
                Toast.makeText(this, "El campo edad esta vacio...", Toast.LENGTH_LONG).show()
            }else if((binding.nameEditText.getText().toString().isNotEmpty()) && (binding.edadEditText.getText().toString().isNotEmpty()) && key){
                key = false
                ShowInterface(it)
            }else{
                key = true
                showText(it)
            }
        }
        binding.virusButton.setOnClickListener{
            resultado = "Los coronavirus son una extensa familia de virus que pueden causar enfermedades leves como el resfriado común, y enfermedades graves como el SRAS (síndrome respiratorio agudo severo) o el sindrome respiratorio de Oriente Medio (MERS-CoV), y más recientemente el nuevo coronavirus identificado por primera vez en la ciudad china de Wuhan, este nuevo virus altamente contagioso fue nombrado oficialmente como SARS-CoV-2, además el nombre oficial de la enfermedad provocada por el nuevo virus es \"COVID-19\" según la Organización Mundial de la Salud.: "
            intent.putExtra("title","Covid-19")
            intent.putExtra("texto",resultado)
            startActivity(intent)
        }

        binding.sintomasButton.setOnClickListener{
            resultado = "Los principales sintomas son: \n"+" \n"+"-Fiebre alta (mayor a 38 grados)\n" +" \n"+ "-Tos seca (sin flemas)\n" +" \n"+ "-Pérdida del sentido del olfato y del gusto\n" +" \n"+ "-Falta de apetito \n" +" \n"+ "-Dolores musculares\n" +" \n"+ "-Fatiga"
            intent.putExtra("title","Sintomas")
            intent.putExtra("texto",resultado)
            startActivity(intent)
        }

        binding.indicacionesButton.setOnClickListener{
            resultado = "-Evite el contacto cercano (*) con personas. Evite conglomeraciones.\n" +
                    " \n" +
                    "-Si usted esta enfermo y presenta síntomas compatibles con el coronavirus COVID-2019 no salga de su casa para evitar contaminar a otras personas.\n" +
                    " \n" +
                    "-Las personas con síntomas compatibles con el coronavirus COVID-19 deben usar una mascarilla que cubra su boca y nariz para proteger a las otras personas de las gotitas contaminadas por el virus al toser o estornudar.\n" +
                    " \n" +
                    "-Lávese con frecuencia las manos con agua y jabón por al menos 20 segundos, especialmente después de tener contacto directo con otras personas. Si no dispone de agua y jabón lávese con una solución que contenga al menos alcohol al 60%. Ver Cómo lavarse las manos?  \n" +
                    " \n" +
                    "-Al toser y estornudar debe cubrirse la boca y la nariz con el brazo (usando el pliegue del codo) o con un pañuelo desechable – tirar el pañuelo inmediatamente a la basura y lavarse las manos.\n" +
                    " \n" +
                    "-Evite tocarse los ojos, nariz o boca con las manos sucias. \n" +
                    " \n" +
                    "-Limpie y desinfecte objetos y susperficies que usted toca con frecuencia con un limpiador desinfectante o con una toallita de limpieza. \n" +
                    " \n" +
                    "-Si tiene fiebre, tos y dificultad para respirar, busque atención médica a tiempo y comparta antecedentes de viajes al extranjero o de contactos sociales con su médico."
            intent.putExtra("title","Indicaciones")
            intent.putExtra("texto",resultado)
            startActivity(intent)
        }
    }

    private fun ShowInterface(view: View){
        binding.apply{
            invalidateAll()
            nameText.text = getString(R.string.finalName)
            nameEditText.visibility = View.VISIBLE
            edadText.visibility = View.VISIBLE
            edadEditText.visibility = View.VISIBLE
            riesgo_text.visibility = View.GONE
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
