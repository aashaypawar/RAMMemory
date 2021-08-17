package org.geeksforgeeks.rammemory

import android.app.ActivityManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view)

        val actManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val memInfo = ActivityManager.MemoryInfo()
        actManager.getMemoryInfo(memInfo)

        val availMemory = memInfo.availMem.toDouble()/(1024*1024*1024)
        val totalMemory= memInfo.totalMem.toDouble()/(1024*1024*1024)

        mTextView.text = "Available RAM: $availMemory\nTotal RAM: $totalMemory"
    }
}