package com.gamecatart.catsavalanchegame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.gamecatart.catsavalanchegame.databinding.FragmentAboutBinding
import com.gamecatart.catsavalanchegame.databinding.FragmentAboutMainHeroBinding
import com.google.android.material.snackbar.Snackbar


class AboutMainHeroFragment : Fragment() {
    private var _binding: FragmentAboutMainHeroBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutMainHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            binding.btnImgExit.setOnClickListener {
                initAlertDialog()
            }

        } catch (e: Exception){
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

    private fun initAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Are you definitely want to log out, the current data will not be saved?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }
}