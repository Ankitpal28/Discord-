package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.api.CommandsAPI
import com.aliucord.entities.Plugin
import com.discord.stores.StoreStream

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class BadgeViewer : Plugin() {
    override fun start(context: Context) {
        commands.registerCommand(
            "whoami",
            "Show your username and user ID",
        ) {
            val me = StoreStream.getUsers().me
            CommandsAPI.CommandResult("${me.username} (${me.id})")
        }

        Utils.showToast("BadgeViewer loaded — /whoami registered")
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
