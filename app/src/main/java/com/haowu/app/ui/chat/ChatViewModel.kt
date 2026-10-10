package com.haowu.app.ui.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haowu.app.data.ChatMessage
import com.haowu.app.data.MockAssistant
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private var nextId = 1L

    val messages: SnapshotStateList<ChatMessage> = mutableStateListOf(
        ChatMessage(
            id = nextId++,
            text = "你好！我是好物助手。聊聊你想闲置或需要的物品吧～（本地演示，离线可用）",
            isFromUser = false
        )
    )

    fun sendMessage(text: String) {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return

        messages.add(
            ChatMessage(id = nextId++, text = trimmed, isFromUser = true)
        )

        viewModelScope.launch {
            delay(450)
            val reply = MockAssistant.replyTo(trimmed)
            messages.add(
                ChatMessage(id = nextId++, text = reply, isFromUser = false)
            )
        }
    }
}
