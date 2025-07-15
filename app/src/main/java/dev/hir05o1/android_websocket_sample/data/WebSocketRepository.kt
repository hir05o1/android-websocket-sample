package dev.hir05o1.android_websocket_sample.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebSocketRepository @Inject constructor(private val webSocket: WebSocketListenerImpl) {
    fun connect() {
        webSocket.connect()
    }

    fun send(text: String): Boolean {
        return webSocket.send(text)
    }

    fun observeMessages(): Flow<String> = webSocket.events

    fun close(code: Int = 1000, reason: String? = null) {
        webSocket.close(code, reason)
    }
}
