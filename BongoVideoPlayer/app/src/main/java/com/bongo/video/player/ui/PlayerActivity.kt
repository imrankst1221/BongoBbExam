package com.bongo.video.player.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.bongo.video.player.R
import com.bongo.video.player.viewmodel.PlayerViewModel
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private lateinit var mPlayerViewModel: PlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        mContext = this
        mActivity = this
        mPlayerViewModel = PlayerViewModel(mActivity, this.videoPlayer)

        initOnClick()
        initController()
    }

    private fun initOnClick() {
        this.btnPlayPause.setOnClickListener {
            mPlayerViewModel.playPauseAction()
        }
        this.btnForward.setOnClickListener {
            mPlayerViewModel.forwardAction()
        }
        this.btnRewind.setOnClickListener {
            mPlayerViewModel.rewindAction()
        }
    }


    private fun initController() {
        mPlayerViewModel.stopAction()
    }
}