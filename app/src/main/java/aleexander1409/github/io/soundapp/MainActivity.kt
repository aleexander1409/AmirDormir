package aleexander1409.github.io.soundapp

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener {

    private var mediaPlayer: MediaPlayer? = null
    private var player: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayStartUp.setOnClickListener {
            if (player == R.raw.windows_startup_sound) {
                mediaPlayer?.let {
                    it.stop()
                    it.reset()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.windows_startup_sound)
                    mediaPlayer?.start()
                    ivAaron.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.aaron_awake))
                }
            } else {
                player = R.raw.windows_startup_sound
                mediaPlayer?.let {
                    it.stop()
                    it.reset()
                }
                mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.windows_startup_sound)
                mediaPlayer?.start()
                ivAaron.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.aaron_awake))
            }
        }
        btnPlayShutDown.setOnClickListener {
            if (player == R.raw.windows_shutdown_sound) {
                mediaPlayer?.let {
                    it.stop()
                    it.reset()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.windows_shutdown_sound)
                    mediaPlayer?.start()
                    ivAaron.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.aaron_sleeping))
                }
            } else {
                player = R.raw.windows_shutdown_sound

                mediaPlayer?.let {
                    it.stop()
                    it.reset()
                }
                mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.windows_shutdown_sound)
                mediaPlayer?.start()
                ivAaron.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.aaron_sleeping))
            }
        }

    }

    override fun onPrepared(p0: MediaPlayer?) {
        p0?.let {
            if (it.isPlaying) it.pause() else it.start()
        }
    }
}
