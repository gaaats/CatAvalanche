package com.gamecarart.carace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gamecarart.carace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GameTask {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    private var mGameViev: GameViev? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnStart.setOnClickListener {
//            mGameViev = GameViev(this, this)
//            mGameViev!!.setBackgroundResource(R.drawable.road)
//            binding.rootLayout.addView(mGameViev)
//            binding.btnStart.visibility = View.GONE
//            binding.tvScore.visibility = View.GONE
//        }


    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun closeGame(score: Int) {
//        val scoreText = "Score : $score"
//        binding.rootLayout.removeView(mGameViev)
//        binding.tvScore.text = scoreText
//        binding.btnStart.visibility = View.VISIBLE
//        binding.tvScore.visibility = View.VISIBLE
//        mGameViev = null
    }
}