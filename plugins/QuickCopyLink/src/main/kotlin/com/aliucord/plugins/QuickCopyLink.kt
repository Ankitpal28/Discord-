package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.api.CommandsAPI
import com.aliucord.entities.Plugin
import com.aliucord.wrappers.ChannelWrapper
import com.discord.stores.StoreStream

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class QuickCopyLink : Plugin() {
    override fun start(context: Context) {
        commands.registerCommand(
            "copychannel",
            "Copy a link to the current channel",
        ) {
            val channel = ChannelWrapper(StoreStream.getChannelsSelected().selectedChannel)
            val guildId = channel.guildId
            val channelId = channel.id
            val link = if (guildId != 0L)
                "https://discord.com/channels/$guildId/$channelId"
            else
                "https://discord.com/channels/@me/$channelId"

            Utils.setClipboard("Channel Link", link)
            CommandsAPI.CommandResult("Copied: $link")
        }

        Utils.showToast("QuickCopyLink loaded — /copychannel registered")
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
