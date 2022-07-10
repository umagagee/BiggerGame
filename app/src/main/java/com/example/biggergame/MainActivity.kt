package com.example.biggergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignNum()
        btnLeft.setOnClickListener{
            checkNumber(true)
            assignNum()

        }
        ////////////////////
        btnRight.setOnClickListener{
            checkNumber(false)

            assignNum()
        }


    }
   private fun checkNumber(isLeftButtonSelected: Boolean){
       val leftNum  = btnLeft.text.toString().toInt()
       val rightNum  = btnRight.text.toString().toInt()
       val isTrue = if (isLeftButtonSelected) leftNum>rightNum else rightNum>leftNum
       if (isTrue){
           bg.setBackgroundColor(Color.GREEN)
           Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
       }else{
           bg.setBackgroundColor(Color.RED)
           Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
       }



    }

    private fun assignNum() {
        val rand = Random()
        val leftnum = rand.nextInt(10)
        var rightNum=leftnum
        while (rightNum==leftnum){
            rightNum=rand.nextInt(10)
        }

        btnLeft.text=leftnum.toString()
        btnRight.text=rightNum.toString()

    }
}