package com.krishna.barchart

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {

    lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         barChart = findViewById<View>(R.id.barChart) as BarChart

        val entries = ArrayList<BarEntry>()
        for(i in 1..400)
        {entries.add(BarEntry(i.toFloat(),Random.nextInt(1, 20).toFloat()))}

         val barDataSet = BarDataSet(entries, "cells")
        val barData = BarData(barDataSet)
        barChart.data = barData
        barChart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return ("OPER00" + value.toInt())
            }
        }

        barChart.legend.isEnabled = false
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.axisRight.isEnabled = false
        barChart.xAxis.setDrawGridLines(false)
        barChart.xAxis.axisLineWidth = 1f
        barChart.description.isEnabled = false
        barChart.axisLeft.setDrawLabels(false)
        barChart.axisLeft.gridColor = Color.WHITE
        barChart.xAxis.textColor = Color.WHITE
        barChart.axisLeft.spaceBottom = 0f
        barChart.axisLeft.axisMinimum = 0f
        barChart.xAxis.labelRotationAngle = 90F


        val color2 = arrayOf(R.color.lamp_black,
                R.color.salmon_pink,
                R.color.light_green,
                R.color.light_blue,
                R.color.violet,
                R.color.water)
        val randomColor = List(400){

            ContextCompat.getColor(this,color2[Random.nextInt(0,6)])
        }


        barDataSet.setColors(randomColor)
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.valueTextSize = 16f
        barChart.invalidate()
    }
}