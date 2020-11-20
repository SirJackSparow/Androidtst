package com.startup.simpletest

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var storage = mutableListOf<String>()
        var i = 0
        edt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                storage.add(p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        reverd.setOnClickListener {
            text.text = "output: " + edt.text.toString().reversed()
        }

        undoredo.setOnClickListener {

            i++
            val handler = Handler()
            val r = Runnable { i = 0 }

            if (i == 1) {
                if (edt.text.isNotEmpty()) {
                    edt.text.delete(edt.length() - 1, edt.length())
                }
                handler.postDelayed(r, 250)
            } else if (i == 2) {
                if (storage.isNotEmpty()) {
                    edt.setText(storage[storage.size - 2])
                    storage.removeAt(storage.size - 2)
                    edt.setSelection(edt.text.length)
                    i = 0
                }

            }
        }
    }

}



