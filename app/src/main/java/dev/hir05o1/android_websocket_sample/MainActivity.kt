package dev.hir05o1.android_websocket_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.hir05o1.android_websocket_sample.ui.chat.ChatView
import dev.hir05o1.android_websocket_sample.ui.theme.Android_websocket_sampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_websocket_sampleTheme {
                ChatView()
            }
        }
    }
}
