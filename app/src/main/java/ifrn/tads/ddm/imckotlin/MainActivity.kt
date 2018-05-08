package ifrn.tads.ddm.imckotlin

import android.support.v7.app.AppCompatActivity
import android.os.Build
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular.setOnClickListener { calcularIMC() }
    }

    private fun calcularIMC() {
        if (et_altura.text.isEmpty()) {
            et_altura.setError("Campo obrigatório")
        } else if (et_peso.text.isEmpty()) {
            et_peso.setError("Campo obrigatório")
        }

        var altura = et_altura.text.toString().toDouble()
        val peso = et_peso.text.toString().toDouble()

        if (altura > 3) altura = altura.div(100)

        val imc = (peso / (altura * altura)).toString()

        val intent: Intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("imc", imc)
        startActivity(intent)
    }
}
