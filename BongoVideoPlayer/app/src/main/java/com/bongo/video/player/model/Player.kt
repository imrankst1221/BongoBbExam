package com.bongo.video.player.model
import android.net.Uri
import android.widget.VideoView

interface Player {
    fun playPause(): Boolean
    fun forward()
    fun rewind()
    fun setPlayer(item: PlayerItem)
}