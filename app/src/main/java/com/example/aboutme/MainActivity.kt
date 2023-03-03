package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

// By AgusLacomi

class MainActivity : AppCompatActivity() {

    /**
     * It's a union between a layout and its view and data
     * activityMainBinding: the name is derived from the name of the layout
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * actual data in activity_main -> TextView.android:text
     */
    private val Name: Name = Name("Estral Esports")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * R means a resource folder
         * layout means a layout folder
         * activity_main means the .xml file
         */
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.name = Name

        binding.button.setOnClickListener {
            addNickname(it)
        }
    }

    /**
     * view is doneButton
     *
     */
    private fun addNickname(view: View) {

        /**
         * The "binding.apply" is setted to make the code easier to read
         * This way we can avoid the binding object in the code.
         *
         * invalidateAll(): To update the user interface We can invalidate all binding expressions
         * so so that be recreated  with the correct data
         *
         * 55. set the nameTextView to editName
         * 56. hide editName
         * 57. hide the button
         * 58. nameTextView visible
         */
        binding.apply {
            Name?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameView.text = nicknameEdit.text
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameView.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}