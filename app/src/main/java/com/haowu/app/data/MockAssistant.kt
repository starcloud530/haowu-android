package com.haowu.app.data

/**
 * 离线 mock 助手：根据关键词返回预设回复，保证无网络也可演示。
 */
object MockAssistant {

    private val replies = listOf(
        "你好！我是好物助手。可以问问我家里有什么、想置换什么～",
        "好的，记下来了。之后「橱柜」上线后，我就能帮你整理物品清单。",
        "听起来不错！等「撮合」功能做好，我会帮你匹配合适的交换对象。",
        "目前是本地演示版，消息不会上传。尽情试用聊天界面吧。",
        "收到。你可以继续描述想闲置或需要的物品。"
    )

    fun replyTo(userText: String): String {
        val t = userText.trim()
        return when {
            t.isEmpty() -> "说点什么吧～"
            t.contains("你好") || t.contains("嗨") || t.contains("hello", true) ->
                "你好呀！我是好物个人助手，随时听你吩咐。"
            t.contains("橱柜") || t.contains("物品") || t.contains("闲置") ->
                "「橱柜」功能安排在后续迭代，当前先用聊天记下你的想法。"
            t.contains("撮合") || t.contains("交换") || t.contains("置换") ->
                "「撮合」会在之后版本开放。现在可以先聊聊你想换什么。"
            t.contains("注册") || t.contains("登录") || t.contains("账号") ->
                "账号注册/登录也是后续任务，当前无需登录即可聊天。"
            t.contains("帮助") || t.contains("功能") || t.contains("怎么用") ->
                "第一周目标：能打开 App、在助手里聊天。注册 / 橱柜 / 撮合都标为后续。"
            else -> replies[kotlin.math.abs(t.hashCode()) % replies.size]
        }
    }
}
