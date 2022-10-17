package com.gamecarartmoster.monsterfall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gamecarartmoster.monsterfall.databinding.FragmentGame2Binding

class Game2Fragment : Fragment(), GameTask {
    private var _binding: FragmentGame2Binding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")
    private var mGameViev: GameViev? = null


    val listLogoEnemy = listOf(
        R.drawable.m21,
        R.drawable.m22,
        R.drawable.m23,
        R.drawable.m24,
        R.drawable.m25,
        R.drawable.m26,
        R.drawable.m27
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGame2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnStartGame2.setOnClickListener {
            mGameViev = GameViev(requireContext(), this, R.drawable.user_model_2, listLogoEnemy)
            mGameViev!!.setBackgroundResource(R.drawable.road_2)
            mGameViev!!.background.alpha = 100
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

        findNavController().navigate(R.id.action_game2Fragment_to_loseFragment)
    }

}