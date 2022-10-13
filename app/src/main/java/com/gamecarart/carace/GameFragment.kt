package com.gamecarart.carace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gamecarart.carace.databinding.FragmentGameBinding

class GameFragment : Fragment(), GameTask {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    private var mGameViev: GameViev? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnStart.setOnClickListener {
            mGameViev =
                GameViev(requireContext(), this, R.drawable.logo_game_1, R.drawable.asteroid_1)
            mGameViev!!.setBackgroundResource(R.drawable.space_1)
            mGameViev!!.alpha = 0.6f
            binding.root.addView(mGameViev)
            binding.btnStart.visibility = View.GONE
            binding.tvScoreGame1.visibility = View.GONE
            binding.imgLogoGame1.visibility = View.GONE
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
        binding.tvScoreGame1.text = scoreText
        binding.btnStart.visibility = View.VISIBLE
        binding.tvScoreGame1.visibility = View.VISIBLE
        binding.imgLogoGame1.visibility = View.VISIBLE
        mGameViev = null
    }

}