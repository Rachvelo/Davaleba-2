package ge.msda.calculator15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.clearButton).setOnClickListener {
            resultTextView.text = ""
            operand = 0.0
            operation = ""
        }

    }

    fun deleteClick(view: View) {
        val result: String = resultTextView.text.toString()
        if(result.length > 1){
            resultTextView.text = result.dropLast(1)
        } else{
            resultTextView.text = ""
        }
    }

    fun numberClick(view: View) {

        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }

    }

    fun equalsClick(view: View) {

        val secOperand = resultTextView.text.toString()
        var secNumber = 0.0

        if (!TextUtils.isEmpty(secOperand)) {
            secNumber = secOperand.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secNumber).toString()
            "-" -> resultTextView.text = (operand - secNumber).toString()
            "*" -> resultTextView.text = (operand * secNumber).toString()
            "/" -> resultTextView.text = (operand / secNumber).toString()
        }

    }

}