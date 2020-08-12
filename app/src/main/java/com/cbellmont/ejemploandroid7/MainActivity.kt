package com.cbellmont.ejemploandroid7

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var onCreate = 0


    companion object {
        const val TAG_USER_TEXT = "TAG_USER_TEXT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.run {
            Log.d("MiTAG", "onSaveInstanceState ha sido leido")
            getString(TAG_USER_TEXT)?.let {
                etText.setText(it)
            }
        }

        // Este codigo es equivalente al codigo de arriba
        // Es otra forma de decir lo mimso
        /*
        savedInstanceState?.let { bundle ->
            bundle.getString(TAG_USER_TEXT)?.let {string ->
                etText.setText(string)
            }
        }
         */
        Log.d("MiTAG", "onCreate $onCreate")
        onCreate++
    }


    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("MiTAG", "onSaveInstanceState ha sido llamada")
        outState.putString(TAG_USER_TEXT, etText.text.toString())
        super.onSaveInstanceState(outState)
    }
}
