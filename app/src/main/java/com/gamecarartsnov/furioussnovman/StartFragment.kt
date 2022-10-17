package com.gamecarartsnov.furioussnovman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gamecarartsnov.furioussnovman.databinding.FragmentStartBinding
import com.google.android.material.snackbar.Snackbar

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            binding.btnHeart.setOnClickListener {
                Snackbar.make(binding.root, "I love you too ♥♥♥", Snackbar.LENGTH_LONG).show()
            }
            binding.btnSettings.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_settingsFragment)
            }
            binding.imgGame1.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_game1Fragment)
            }
            binding.imgGame2.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_game2Fragment)
            }
            binding.imgLidearboard.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_bestScoreFragment)
            }
        } catch (e: Exception) {
            snackBarError()
        }
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun snackBarError() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

}