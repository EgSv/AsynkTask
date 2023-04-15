package ru.startandroid.develop.asynktask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mt: MyTask? = null
    var tvInfo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById<View>(R.id.tvInfo) as TextView
    }

    fun onClick(v: View) {
        mt = MyTask()
        mt!!.execute()
    }

    internal inner class MyTask : AsyncTask<Void?, Void?, Void?>() {
        override fun onPreExecute() {
            super.onPreExecute()
            tvInfo!!.text = "Begin"
        }

        override fun doInBackground(vararg params: Void?): Void? {
            try {
                Thread.sleep(2000)
            } catch (e:InterruptedException) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            tvInfo!!.text = "End"
        }
    }
}