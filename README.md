# 好物（Haowu）Android

个人助手聊天壳：Kotlin + Jetpack Compose，离线可跑的本地 mock 回复。无 Firebase / 支付 / 地图。

- **applicationId**：`com.haowu.app`
- **minSdk**：26
- **仓库**：https://github.com/starcloud530/haowu-android

## 如何打开

1. 安装 [Android Studio](https://developer.android.com/studio)（建议 Ladybug / Koala 或更新），并装好 Android SDK 34。
2. **File → Open**，选择本仓库根目录（含 `settings.gradle.kts` 的那一层）。
3. 等待 Gradle Sync；若提示缺少 JDK，选用内置 JBR 17。
4. 连接模拟器或真机，点击 Run 运行 `app`。
5. （可选）将 `local.properties.example` 复制为 `local.properties`，或让 Android Studio 自动生成 `sdk.dir`。

本机无 Android SDK 时，仍可阅读 / 编辑完整源码树；真正编译需在有 SDK 的环境完成。

## 目录结构

```
haowu-android/
├── app/
│   ├── build.gradle.kts          # 应用模块与 Compose 依赖
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/haowu/app/
│       │   ├── MainActivity.kt
│       │   ├── data/             # 消息模型 + MockAssistant
│       │   ├── ui/chat/          # ChatScreen + ChatViewModel
│       │   └── ui/theme/         # 颜色 / 字体 / Theme
│       └── res/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradle/wrapper/
└── README.md
```

## 当前功能（第一周）

- 主屏：个人助手聊天（消息列表 + 输入框 + 发送）
- 本地 mock 回复，**无需网络**
- Material 3 主题，包结构 `ui/chat`、`ui/theme`、`data`

## 后续任务（暂不实现）

| 能力 | 状态 |
|------|------|
| 注册 / 登录 | **后续** |
| 橱柜（物品清单） | **后续** |
| 撮合（置换匹配） | **后续** |

## 依赖说明

尽量精简：AndroidX Core / Activity Compose / Lifecycle + Compose BOM（UI、Material3）。不含网络、推送、支付、地图第三方库。

## 许可证

私有仓库；内部协作使用。
