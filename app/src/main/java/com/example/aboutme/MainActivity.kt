package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * R means a resource folder
         * layout means a layout folder
         * activity_main means the .xml file
         */
        setContentView(R.layout.activity_main)

        val doneButton: Button = findViewById(R.id.button)

        doneButton.setOnClickListener {
            addNickname(doneButton)
        }

    }

    /**
     * view is the doneButton
     *
     */
    private fun addNickname(view: View) {

        val editName: TextView = findViewById(R.id.nickname_edit)
        val nameTextView: TextView = findViewById(R.id.nickname_view)

        /**
         * 46. set the nameTextView to editName
         * 47. hide editName
         * 48. hide the button
         * 49. nameTextView visible
         */
        nameTextView.text = editName.text
        editName.visibility = View.GONE
        view.visibility = View.GONE
        nameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}