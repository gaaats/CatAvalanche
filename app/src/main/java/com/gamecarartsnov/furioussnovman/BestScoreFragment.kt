package com.gamecarartsnov.furioussnovman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.gamecarartsnov.furioussnovman.databinding.FragmentBestScoreBinding
import com.gamecarartsnov.furioussnovman.recycler.Person
import com.gamecarartsnov.furioussnovman.recycler.PersonListAdapter
import com.google.android.material.snackbar.Snackbar

class BestScoreFragment : Fragment() {
    private var _binding: FragmentBestScoreBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    private val adapter by lazy {
        PersonListAdapter()
    }

    val listNames = listOf(
        "sasha",
        "masha",
        "roma",
        "denis",
        "eva",
        "nastya",
        "kolya",
        "john",
        "noname",
        "rembo",
        "frodo",
        "gimli"
    )

    val listPersons = mutableListOf<Person>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBestScoreBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        for (i in 1..50){
            val person = Person(name = listNames.random())
            listPersons.add(person)
        }

        try {
            initOnItemClickListener()
            addVertAndHorDividers()
            adapter.submitList(listPersons)
            binding.recyclerView.adapter = adapter
            binding.btnImgExit.setOnClickListener {
                requireActivity().onBackPressed()
            }
            binding.btnGoBack.setOnClickListener {
                requireActivity().onBackPressed()
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

    private fun addVertAndHorDividers() {
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initOnItemClickListener() {
        adapter.setOnItemClickListener {
            Snackbar.make(
                binding.root,
                "My name is ${it.name}",
                Snackbar.LENGTH_LONG
            ).show()

        }
    }
}