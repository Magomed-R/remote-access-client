package com.example.remoteaccessclient

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: FloatingActionButton = findViewById(R.id.fab)
        val modalNewConnection: ConstraintLayout = findViewById(R.id.include_modal_new_connection)
        val modalBackground: FrameLayout = findViewById(R.id.modal_background)
        val modalContent: LinearLayout = findViewById(R.id.modal_content)
        val ipInput: EditText = findViewById(R.id.ip_input)

        addButton.setOnClickListener {
            modalNewConnection.isVisible = true
        }

        modalBackground.setOnClickListener {
            modalNewConnection.isVisible = false
            hideKeyboard(this, ipInput)
        }

        modalContent.setOnClickListener {}
    }

    fun hideKeyboard(context: Context, editText: EditText) {
        val inputMM = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMM.hideSoftInputFromWindow(editText.windowToken, 0)
    }

}