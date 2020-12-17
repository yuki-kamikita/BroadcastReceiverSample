package com.akaiyukiusagi.broadcastreceiversample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* ブロードキャストを受け取る処理 */
        // 何をした時に受け取るか
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED)   // インストール
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED) // アンインストール
        intentFilter.addDataScheme("package")

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                // 受け取った時の挙動
                Log.d("MyReceiver", "change install status: $intent")
            }
        }

        // 実行
        registerReceiver(receiver, intentFilter)
    }
}

// 公式：https://developer.android.com/guide/components/broadcasts?hl=ja#context-registered-receivers
// 参考：https://codechacha.com/ja/android-install-uninstall-events/