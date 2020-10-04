package com.example.broadcastapp

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkConnection()


        btn_nextActivitysplash.setOnClickListener {
           intent = Intent(this@MainActivity,SplashActivity2 ::class.java)
            startActivity(intent)
        }
    }
    private fun checkConnection() {
        //when we used Services we used Connectivity Manager
        val manager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //we will call the Method
        val networkInfo = manager.activeNetworkInfo
        // we will Check network null or not
        if (null !=networkInfo) {
            if (networkInfo.type == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this,"Wifi Connected",Toast.LENGTH_SHORT).show()
            }
             else if(networkInfo.type == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this,"Mobile Data Connected",Toast.LENGTH_SHORT).show()
            }
        }
       else{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.alert_dialog)
            dialog.setCanceledOnTouchOutside(false)
            //set height of dailog box, call dialog
            dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT)
            //set Backround of this layout is transparents
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //i will call the Button
            dialog.btn_tryAgain.setOnClickListener{
                //when we click the button it will check the NetworkConnectivity Recread the dialogBox internet it show TryAgain
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}