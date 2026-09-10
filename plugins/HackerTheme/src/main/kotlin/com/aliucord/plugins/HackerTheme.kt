package com.aliucord.plugins

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

@AliucordPlugin(requiresRestart = true)
@Suppress("unused")
class HackerTheme : Plugin() {
    override fun start(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        Utils.showToast("HackerTheme loaded")
        // Full green/black recolor of every surface needs hooking Discord's
        // color-resolver class — that name isn't confirmed from this repo's
        // source, only from your own decompiled APK (jadx-gui).
    }

    override fun stop(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        patcher.unpatchAll()
    }
}
