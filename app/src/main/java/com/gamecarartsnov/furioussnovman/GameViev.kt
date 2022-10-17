package com.gamecarartsnov.furioussnovman

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar

class GameViev(
    var contextttt: Context,
    var gameTask: GameTask,
    val myCar: Int,
    val enemyLogoList: List<Int>
) : View(contextttt) {

    private var myPaint: Paint? = null
    private var myPaintBonus: Paint? = null
    private var speed = 8
    private var score = 0
    private var time = 0
    private var myCarPosition = 0

    var timer = System.currentTimeMillis()

    private var counterSpeed = 0

    private var otherCars = ArrayList<HashMap<String, Any>>()
    private var otherBonus = ArrayList<HashMap<String, Any>>()

    private var vievVidth = 0
    private var vievHeight = 0

    var currentEnemyAvatar = enemyLogoList.random()


    init {
        myPaint = Paint()
        myPaintBonus = Paint()
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
        vievVidth = this.measuredWidth
        vievHeight = this.measuredHeight

        var difff = System.currentTimeMillis() - timer

        if (time % 700 < 10 + speed) {
            val map = HashMap<String, Any>()

            // here
            if (difff >= 5000) {
                val mapBonus = HashMap<String, Any>()
                mapBonus["lane"] = (0..2).random()
                mapBonus["startTime"] = time
                otherBonus.add(mapBonus)
            }


            map["lane"] = (0..2).random()
            map["startTime"] = time
            otherCars.add(map)
        }
        time = time + 10 + speed
        val carVidth = vievVidth / 5
        val carHeight = carVidth + 10
        myPaint!!.style = Paint.Style.FILL

        //here
        val bonusVidth = vievVidth / 5
        val bonusHeight = carVidth + 10
        myPaintBonus!!.style = Paint.Style.FILL
        val bonus = resources.getDrawable(R.drawable.heart, null)


        val d = resources.getDrawable(myCar, null)

        d.setBounds(
            myCarPosition * vievVidth / 3 + vievVidth / 15 + 25,
            vievHeight - 2 - carHeight,
            myCarPosition * vievVidth / 3 + vievVidth / 15 + carVidth - 25,
            vievHeight - 2
        )
        d.draw(canvas!!)
        myPaint!!.color = Color.GREEN
        var highScore = 0


        if (difff >= 5000) {
            currentEnemyAvatar = enemyLogoList.random()
            timer = System.currentTimeMillis()
            speed = speed + 1 + Math.abs(score / 8)
        }


        for (i in otherCars.indices) {
            try {
                val carX = otherCars[i]["lane"] as Int * vievVidth / 3 + vievVidth / 15
                var carY = time - otherCars[i]["startTime"] as Int
//                if (counterSpeed%5 ==0 && counterSpeed != 0){
//                    currentEnemyAvatar = enemyLogoList.random()
//                }

                val d2 = resources.getDrawable(currentEnemyAvatar, null)

                d2.setBounds(carX + 25, carY - carHeight, carX + carVidth, carY)
                d2.draw(canvas)
                if (otherCars[i]["lane"] as Int == myCarPosition) {
                    if (carY > vievHeight - 2 - carHeight && carY < vievHeight - 2) {
                        gameTask.closeGame(score)
                    }
                    if (carY > vievHeight + carHeight) {
                        otherCars.removeAt(i)
                        score++
                        counterSpeed++

                        if (score > highScore) {
                            highScore = score
                        }
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        myPaint!!.color = Color.WHITE
        myPaint!!.textSize = 40f
        canvas.drawText("Score: $score", 80f, 80f, myPaint!!)
        canvas.drawText("Speed: $speed", 380f, 80f, myPaint!!)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                val x1 = event.x
                if (x1 < vievVidth / 2) {
                    if (myCarPosition > 0) {
                        myCarPosition--
                    }
                }
                if (x1 > vievVidth / 2) {
                    if (myCarPosition < 2) {
                        myCarPosition++
                    }
                }
                invalidate()
            }
            MotionEvent.ACTION_UP -> {

            }
        }

        return true
    }

    private fun snackBarError() {
        Snackbar.make(
            this,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
    }


}

