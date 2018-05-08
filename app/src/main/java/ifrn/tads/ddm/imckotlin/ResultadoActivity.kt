package ifrn.tads.ddm.imckotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    var situacao: String = ""
    var feedback: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val imc = intent.getStringExtra("imc").toDouble()
        situacaoIMC(imc)

        et_imc.keyListener = null
        et_situacao.keyListener = null
        et_feedback.keyListener = null

        et_imc.setText("%.3f".format(imc))
        et_situacao.setText(situacao)
        et_feedback.setText(feedback)

        btn_voltar.setOnClickListener { finish() }
    }

    private fun situacaoIMC(imc: Double) {
        if (imc < 16.91) {
            situacao = "Muito abaixo do peso"
            feedback = "Queda de cabelo, infertilidade, ausência menstrual"
        } else if (imc < 18.41) {
            situacao = "Abaixo do peso"
            feedback = "Fadiga, stress, ansiedade"
        } else if (imc < 24.91) {
            situacao = "Peso normal"
            feedback = "Menor risco de doenças cardíacas e vasculares"
        } else if (imc < 29.91) {
            situacao = "Acima do peso"
            feedback = "Fadiga, má circulação, varizes"
        } else if (imc < 34.91) {
            situacao = "Obesidade Grau 1"
            feedback = "Diabetes, angina, infarto, aterosclerose"
        } else if (imc < 40.01) {
            situacao = "Obesidade Grau 2"
            feedback = "Apneia do sono, falta de ar"
        } else {
            situacao = "Obesidade Grau 3"
            feedback = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC"
        }
    }

}
