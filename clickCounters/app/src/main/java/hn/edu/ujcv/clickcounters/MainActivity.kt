package hn.edu.ujcv.clickcounters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var startTime  : Long = 60000
    private var counter: Int   = 0
    private var promedioClicks = 0
    private var timeLeftMillis : Long  = startTime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicio()
        btnStartTimer.setOnClickListener { startGame() }
        btnClicker.setOnClickListener {tapper()}
        btnRestartTimer.setOnClickListener { inicio() }
    }

    private fun tapper() {
        counter ++
        txvTapCounter .text = "$counter"

    }

    private fun startGame() {
        if (NameValidation.playerName(txtPlayerName.text.toString()) == false ){
            Toast.makeText(this ,"Enter Name before Starting" , Toast.LENGTH_SHORT).show()
        }else {
            object : CountDownTimer(timeLeftMillis, 1000) {

                override fun onTick(millisRemainig: Long) {
                    btnClicker.isEnabled = true
                    timeLeftMillis = millisRemainig
                    updateCountDown()
                }

                override fun onFinish() {
                    btnClicker.isEnabled = false
                    txvAvarageName.setText(txtPlayerName.text)
                    var clicksPerSecond = AvarageCalculation.avarage(counter)
                    txvAvarage.setText("Your avarage of clicks per second is  : $clicksPerSecond clicks")
                }
            }.start()
        }
    }

    fun updateCountDown(){
        var minutes : Int = ((timeLeftMillis.toInt())/1000)/60
        var seconds : Int = ((timeLeftMillis.toInt())/1000)%60
        var timeFormat = String.format("%2d:%2d", minutes , seconds)
        txvTimerCountDown.text = timeFormat
    }
    private fun inicio() {
        txvAvarageName.text = ""
        txvAvarage.text  = ""
        txvTimerCountDown.text = "1:00"
        btnClicker.isEnabled = false
        btnStartTimer.isEnabled = true
        timeLeftMillis = startTime
        counter = 0
        txvTapCounter.text = "0:0"


    }

}