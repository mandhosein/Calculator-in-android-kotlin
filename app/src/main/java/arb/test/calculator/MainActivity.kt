package arb.test.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var oprator = ""
    var num1 = ""
    var num2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun OnClick(view:View){
        when(view.id){
            R.id.btn_calculat_0 -> addNumber("0")
            R.id.btn_calculat_1 -> addNumber("1")
            R.id.btn_calculat_2 -> addNumber("2")
            R.id.btn_calculat_3 -> addNumber("3")
            R.id.btn_calculat_4 -> addNumber("4")
            R.id.btn_calculat_5 -> addNumber("5")
            R.id.btn_calculat_6 -> addNumber("6")
            R.id.btn_calculat_7 -> addNumber("7")
            R.id.btn_calculat_8 -> addNumber("8")
            R.id.btn_calculat_9 -> addNumber("9")
            R.id.btn_calculat_clear -> clear()
            R.id.btn_calculat_plus -> operator("+")
            R.id.btn_calculat_min -> operator("-")
            R.id.btn_calculat_div -> operator("/")
            R.id.btn_calculat_mul -> operator("*")
            R.id.btn_calculat_equals -> calculator()
        }
    }

    private fun operator(op: String) {
        if (tv_calculat_result.text.toString().isEmpty() && num1.isEmpty()){
            Toast.makeText(applicationContext,"you did not enter the first number",Toast.LENGTH_SHORT).show()
            return
        }

        if (oprator.isEmpty()){
            num1 = tv_calculat_result.text.toString()
            tv_calculat_result.text = ""
            tv_calculat_operator.text = op
            oprator = op
            tv_calculat_preview.text = "$num1 $oprator"
        }else{
            if (tv_calculat_result.text.toString().isNotEmpty()){
                num2 = tv_calculat_result.text.toString()

                tv_calculat_preview.text = "$num1 $oprator $num2"
            }

            if (num1.isNotEmpty() && num2.isEmpty()){
                tv_calculat_operator.text = op
                oprator = op
                tv_calculat_preview.text = "$num1 $oprator $num2"
            }
        }
    }

    private fun addNumber(numbers:String) = tv_calculat_result.append(numbers)

    private fun clear() {
        tv_calculat_result.text = ""
        tv_calculat_operator.text = "c"
        tv_calculat_preview.text = ""
        num1 = ""
        num2 = ""
        oprator = ""
    }

    private fun calculator() {

        if (num1.isEmpty()){
            Toast.makeText(applicationContext,"you did not enter anal",Toast.LENGTH_SHORT).show()
        }else if(tv_calculat_result.text.isEmpty() && num2.isEmpty()){
            Toast.makeText(applicationContext,"you did not enter the second number",Toast.LENGTH_SHORT).show()
        }else {
            tv_calculat_operator.text = "="
            num2 = tv_calculat_result.text.toString()
            if (oprator.equals("+")) {
                tv_calculat_preview.text = "$num1 $oprator $num2"
                tv_calculat_result.text = (num1.toInt() + num2.toInt()).toString()
                num1 = tv_calculat_result.text.toString()
                num2 = ""
                oprator = ""
            } else if (oprator.equals("-")) {
                tv_calculat_preview.text = "$num1 $oprator $num2"
                tv_calculat_preview.text = "$num1 $oprator $num2"
                tv_calculat_result.text = (num1.toInt() - num2.toInt()).toString()
                num1 = tv_calculat_result.text.toString()
                num2 = ""
                oprator = ""
            } else if (oprator.equals("*")) {
                tv_calculat_preview.text = "$num1 $oprator $num2"
                tv_calculat_result.text = (num1.toInt() * num2.toInt()).toString()
                num1 = tv_calculat_result.text.toString()
                num2 = ""
                oprator = ""
            } else if (oprator.equals("/")) {
                tv_calculat_preview.text = "$num1 $oprator $num2"
                tv_calculat_result.text = (num1.toDouble() / num2.toDouble()).toString()
                num1 = tv_calculat_result.text.toString()
                num2 = ""
                oprator = ""
            }
        }
    }

    
}
