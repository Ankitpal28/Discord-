package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.api.CommandsAPI
import com.aliucord.entities.Plugin
import com.discord.stores.StoreStream

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class QuickCopyLink : Plugin() {
    override fun start(context: Context) {
        commands.registerCommand(
            "copychannel",
            "Copy a link to the current channel",
        ) {
            val channel = StoreStream.getChannelsSelected().selectedChannel
            val link = if (channel.guildId != 0L)
                "https://discord.com/channels/${channel.guildId}/${channel.id}"
            else
                "https://discord.com/channels/@me/${channel.id}"

            Utils.setClipboard("Channel Link", link)
            CommandsAPI.CommandResult("Copied: $link")
        }

        Utils.showToast("QuickCopyLink loaded — /copychannel registered")
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
