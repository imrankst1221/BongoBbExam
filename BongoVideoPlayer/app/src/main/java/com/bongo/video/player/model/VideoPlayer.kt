package com.bongo.video.player.model

import android.widget.VideoView
import com.bongo.video.player.utility.Constants

class VideoPlayer constructor(
    private var mPlayer: VideoView
): Player {
    private var mPlayPosition: Int = 0
    companion object{
        private lateinit var instance: Player
        fun getInstance(videoView: VideoView): Player{
                if (!::instance.isInitialized){
                    instance = VideoPlayer(videoView)
                }else{
                    return instance
                }
            return instance
        }
    }

    override fun playPause(): Boolean {
        if (mPlayer.isPlaying){
            mPlayPosition = mPlayer.currentPosition
            mPlayer.pause()
            return false
        }else{
            mPlayer.start()
            return true
        }
    }

    override fun forward() {
        mPlayPosition += Constants.PLAYER_FORWARD_REWARD_TIME
        if(mPlayer.duration > mPlayPosition){
            mPlayer.seekTo(mPlayPosition)
        }
    }

    override fun rewind() {
        mPlayPosition -= Constants.PLAYER_FORWARD_REWARD_TIME
        if (mPlayPosition <= 0) {
            mPlayPosition = 0
        }
        mPlayer.seekTo(mPlayPosition)
    }

    override fun setPlayer(item: PlayerItem) {
        mPlayer.setVideoURI(item.uri)
        mPlayer.requestFocus()
    }

}