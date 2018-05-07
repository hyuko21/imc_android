package ifrn.tads.ddm.imckotlin

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.content.Intent

import kotlinx.android.synthetic.main.activity_main.*

/**
 * A login screen that offers login via email/password.
 */
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
