package eduardo.gladzik.finalproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import eduardo.gladzik.finalproject.R

class SplashScreen : AppCompatActivity() {

    private var delayhandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000

    internal val runnable = Runnable {
        if(!isFinishing) {
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        delayhandler = Handler()
        delayhandler!!.postDelayed(runnable, SPLASH_DELAY)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        delayhandler?.let {
            it.removeCallbacks(runnable)
        }
    }

    private fun onWindowFocusChange(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}