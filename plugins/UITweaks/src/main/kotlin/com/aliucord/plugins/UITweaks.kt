package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.patcher.*
import com.discord.stores.StoreUserTyping

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class UITweaks : Plugin() {
    override fun start(context: Context) {
        // Confirmed real hook (from Aliucord's own example plugin):
        // stops your own typing status from being sent to others.
        patcher.instead<StoreUserTyping>(
            "setUserTyping",
            Long::class.java,
        ) {
            null
        }

        Utils.showToast("UITweaks loaded — typing indicator hidden")
        // Hiding embeds / other UI elements still needs the real chat
        // adapter view-holder classes from your own decompiled APK.
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
