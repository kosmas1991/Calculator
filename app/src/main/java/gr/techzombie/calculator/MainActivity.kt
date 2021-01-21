package gr.techzombie.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var operator: String? = ""
    var operator2: String? = ""


    fun numberPressed(view: View) {

        var currentButton = view as Button

        when (currentButton.id) {
            R.id.bu0 -> operator += "0"
            R.id.bu1 -> operator += "1"
            R.id.bu2 -> operator += "2"
            R.id.bu3 -> operator += "3"
            R.id.bu4 -> operator += "4"
            R.id.bu5 -> operator += "5"
            R.id.bu6 -> operator += "6"
            R.id.bu7 -> operator += "7"
            R.id.bu8 -> operator += "8"
            R.id.bu9 -> operator += "9"
            R.id.buac -> operator = ""
            R.id.budot -> operator += if (operator!!.contains('.')) "" else "."
            R.id.buplusminus -> operator = (0 - operator!!.toDouble()).toString()
            R.id.bupercent -> operator = (operator!!.toDouble() / 100.0).toString()
            R.id.buadd -> fuadd(operator!!)
            R.id.buabs -> fuabs(operator!!)
            R.id.bumul -> fumul(operator!!)
            R.id.budiv -> fudiv(operator!!)

        }
        textView.text = operator
    }

    var op:String?=""

    fun fuadd(operator: String) {
        this.operator2 = operator
        this.operator = ""
        this.op="add"
    }
    fun fuabs(operator: String) {
        this.operator2 = operator
        this.operator = ""
        this.op="abs"
    }
    fun fumul(operator: String){
        this.operator2 = operator
        this.operator = ""
        this.op="mul"
    }
    fun fudiv(operator: String){
        this.operator2 = operator
        this.operator = ""
        this.op="div"
    }

    fun sum(view: View) {
    when(op) {
        "add" -> fuequaladd(this.operator!!)
        "abs" -> fuequalabs(this.operator!!)
        "mul" -> fuequalmul(this.operator!!)
        "div" -> fuequaldiv(this.operator!!)

    }
    }

    fun fuequaladd(operator: String) {
        textView.text = (this.operator2!!.toDouble() + this.operator!!.toDouble()).toString()
        this.operator=""
        this.operator2=""
    }
    fun fuequalabs(operator: String) {
        textView.text = (this.operator2!!.toDouble() - this.operator!!.toDouble()).toString()
        this.operator=""
        this.operator2=""
    }
    fun fuequalmul(operator: String) {
        textView.text = (this.operator2!!.toDouble() * this.operator!!.toDouble()).toString()
        this.operator=""
        this.operator2=""
    }
    fun fuequaldiv(operator: String) {
        textView.text = (this.operator2!!.toDouble() / this.operator!!.toDouble()).toString()
        this.operator=""
        this.operator2=""
    }
}
