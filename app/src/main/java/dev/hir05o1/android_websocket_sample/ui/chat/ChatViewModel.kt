package dev.hir05o1.android_websocket_sample.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hir05o1.android_websocket_sample.data.ChatMessage
import dev.hir05o1.android_websocket_sample.data.WebSocketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val webSocketRepository: WebSocketRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<ChatMessage>>(emptyList())
    val uiState: StateFlow<List<ChatMessage>> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            webSocketRepository.connect()

            webSocketRepository.observeMessages().collect { text ->
                _uiState.update {
                    it + ChatMessage(text = text, isUser = false)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        webSocketRepository.close()
    }

    fun send(text: String) {
        _uiState.update {
            it + ChatMessage(text = text, isUser = true)
        }
        webSocketRepository.send(text)
    }
} 
