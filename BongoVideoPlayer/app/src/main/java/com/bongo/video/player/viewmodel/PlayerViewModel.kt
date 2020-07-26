package com.bongo.video.player.viewmodel

import android.app.Activity
import android.net.Uri
import android.widget.VideoView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bongo.video.player.R
import com.bongo.video.player.model.Player
import com.bongo.video.player.model.PlayerItem
import com.bongo.video.player.model.VideoPlayer
import kotlinx.android.synthetic.main.activity_player.*

class PlayerViewModel constructor(
    private val mActivity : Activity,
    private val mVideoView: VideoView
): ViewModel() {
    private var mPlayer: Player = VideoPlayer.getInstance(mVideoView)
    private val mPlayerPosition: MutableLiveData<Int> = MutableLiveData()
    private val mPlayerList: MutableLiveData<ArrayList<PlayerItem>> by lazy {
        MutableLiveData<ArrayList<PlayerItem>>()
    }

    init{
        mPlayer.setPlayer(getDemoPlayerData(0))  /** dummy position **/
    }

    fun getPlayerList(): MutableLiveData<ArrayList<PlayerItem>>{
        return mPlayerList
    }

    fun getPlayerPosition(): MutableLiveData<Int>{
        return mPlayerPosition
    }

    fun playPauseAction(){
        if(mPlayer.playPause()){
            mActivity.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_pause))
        }else{
            mActivity.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_play))
        }
    }

    fun forwardAction(){
        mPlayer.forward()
    }

    fun rewindAction(){
        mPlayer.rewind()
    }

    fun stopAction(){
        mVideoView.setOnCompletionListener {
            mActivity.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_play))
        }
    }

    private fun setPlayerPosition(position: Int){
        mPlayerPosition.value = position
    }

    private fun getDemoPlayerData(position: Int): PlayerItem{
        setPlayerPosition(position)
        val dummyList : ArrayList<PlayerItem> = ArrayList()
        dummyList.add(PlayerItem(Uri.parse("android.resource://" + mActivity.applicationContext.packageName + "/" + R.raw.dummy_video), "Dummy 1"))
        mPlayerList.value = dummyList
        return mPlayerList.value!![mPlayerPosition.value!!]
    }
}