package com.example.broadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony

class MySmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (intent.action.equals(TelephonySms.intent.SMS_RECEIVER_ACTION)){
            val builder = Build()
            val pda = (intent.extras.get("pdus") as Array<*>)
            }
    }
    }
}
