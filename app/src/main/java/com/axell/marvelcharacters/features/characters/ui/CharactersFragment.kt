package com.axell.marvelcharacters.features.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.axell.marvelcharacters.R
import com.axell.marvelcharacters.core.platform.BaseFragment
import com.axell.marvelcharacters.databinding.FragmentCharactersBinding
import com.axell.marvelcharacters.features.characters.modelview.CharacterView
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CharactersFragment : BaseFragment(R.layout.fragment_characters) {

    private var _binding: FragmentCharactersBinding? = null
    private val charactersViewModel by viewModels<CharactersViewModel>()
    private lateinit var adapter: CharacterAdapter
    private lateinit var characterListener: CharacterAdapter.CharacterListener
    private val characters = mutableListOf<CharacterView>()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onBind() {
        characterListener = object : CharacterAdapter.CharacterListener {
            override fun characterSelected(character: CharacterView) {
                Timber.d("characterSelected: $character")
                Toast.makeText(requireContext(), character.toString(), Toast.LENGTH_LONG).show()
            }
        }
        initView()
        initViewModel()
    }

    private fun initView() {
        adapter = CharacterAdapter(characters, characterListener)

        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacters.itemAnimator = DefaultItemAnimator()
        binding.rvCharacters.setHasFixedSize(true)
        binding.rvCharacters.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.HORIZONTAL
            )
        )
        binding.rvCharacters.adapter = adapter
    }

    private fun initViewModel() {
        charactersViewModel.loadCharacters()
        charactersViewModel.characters().observe {
            characters.clear()
            characters.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}
