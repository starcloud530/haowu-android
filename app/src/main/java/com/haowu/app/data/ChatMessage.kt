package com.haowu.app.data

/**
 * 聊天消息模型。本地 mock，无网络依赖。
 */
data class ChatMessage(
    val id: Long,
    val text: String,
    val isFromUser: Boolean,
    val timestampMillis: Long = System.currentTimeMillis()
)
