package com.gamecarartmoster.monsterfall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gamecarartmoster.monsterfall.databinding.FragmentGameBinding

class GameFragment : Fragment(), GameTask {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    val listLogoEnemy = listOf(
        R.drawable.m11,
        R.drawable.m12,
        R.drawable.m13,
        R.drawable.m14,
        R.drawable.m15,
        R.drawable.m16,
    )

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
                GameViev(requireContext(), this, R.drawable.user_model_1, listLogoEnemy)
            mGameViev!!.setBackgroundResource(R.drawable.road_1)
            mGameViev!!.background.alpha = 100
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

        findNavController().navigate(R.id.action_gameFragment_to_loseFragment)
    }

}