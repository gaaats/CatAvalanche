package com.gamecarart.carace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gamecarart.carace.databinding.FragmentGame2Binding

class Game2Fragment : Fragment(), GameTask {
    private var _binding: FragmentGame2Binding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")
    private var mGameViev: GameViev? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGame2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnStartGame2.setOnClickListener {
            mGameViev = GameViev(requireContext(), this, R.drawable.logo_game_2, R.drawable.asteroid_2)
            mGameViev!!.setBackgroundResource(R.drawable.space_2)
            mGameViev!!.alpha = 0.6f
            binding.root.addView(mGameViev)
            binding.btnStartGame2.visibility = View.GONE
            binding.tvScoreGame2.visibility = View.GONE
            binding.imgLogoGame2.visibility = View.GONE
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun closeGame(score: Int) {
        val scoreText = "Score : $score"
        binding.root.removeView(mGameViev)
        binding.tvScoreGame2.text = scoreText
        binding.btnStartGame2.visibility = View.VISIBLE
        binding.tvScoreGame2.visibility = View.VISIBLE
        binding.imgLogoGame2.visibility = View.VISIBLE
        mGameViev = null
    }

}