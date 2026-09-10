package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class AlwaysAnimate : Plugin() {
    override fun start(context: Context) {
        Utils.showToast("AlwaysAnimate loaded")
        // TODO (needs your own APK): find the avatar/emoji image-loading
        // helper and force it to request the animated variant + loop.
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
