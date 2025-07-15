package dev.hir05o1.android_websocket_sample.data

data class ChatMessage(
    val text: String, val isUser: Boolean, val timestamp: Long = System.currentTimeMillis()
)
