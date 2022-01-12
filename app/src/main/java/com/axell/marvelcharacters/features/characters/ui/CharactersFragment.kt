package com.axell.marvelcharacters.features.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import coil.compose.rememberImagePainter
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

    @Composable
    fun CharacterList(characters: List<CharacterView>){
        LazyColumn{
            items(characters){ character ->
                Character(name = character.name, picture =character.thumbnail )
            }
        }
    }

    @Composable
    fun Character(name: String, picture: String) {
        Row {
            Image(
                painter = rememberImagePainter(picture),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CharacterPreview() {
        Row {
            Image(
                painter = rememberImagePainter("https://picsum.photos/200"),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = "Spiderman",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
            )

        }
    }
}
