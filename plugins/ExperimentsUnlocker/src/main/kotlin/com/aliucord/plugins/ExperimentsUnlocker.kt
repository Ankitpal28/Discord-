package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class ExperimentsUnlocker : Plugin() {
    override fun start(context: Context) {
        Utils.showToast("ExperimentsUnlocker loaded")
        // TODO (needs your own APK): find the local experiment-store class
        // and patch its bucket-lookup to always return "enabled".
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
