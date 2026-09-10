package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.patcher.*
import com.discord.api.presence.Presence
import com.discord.stores.StoreStream

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class PlatformIndicators : Plugin() {
    override fun start(context: Context) {
        // Confirmed real hook point — Aliucord's own "Decorations" core
        // plugin patches this exact class/method/signature the same way.
        patcher.after<StoreStream>(
            "handlePresenceUpdate",
            Long::class.javaPrimitiveType!!,
            Presence::class.java,
        ) { param ->
            @Suppress("UNCHECKED_CAST")
            val presence = param.args[1] as Presence

            // TODO (needs your own APK): the per-platform status data is
            // real at the Discord protocol level (every client receives a
            // "client_status" object with desktop/mobile/web fields per
            // user), but the exact Kotlin field/method name on this
            // Presence class isn't confirmed from Aliucord's own source.
            // In jadx, inspect this Presence class's fields/methods —
            // look for something deserializing "client_status" from the
            // gateway payload — then read it here and store or display it
            // (e.g. as a small icon next to the username).
        }

        Utils.showToast("PlatformIndicators loaded (scaffold — see TODO)")
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
