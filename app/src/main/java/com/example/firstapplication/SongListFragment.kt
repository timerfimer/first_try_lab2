package com.example.firstapplication

import SongAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firstapplication.databinding.FragmentSongListBinding

class SongListFragment : Fragment() {
    lateinit var binding: FragmentSongListBinding

    lateinit var adapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSongListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Song>()
        list.add(Song("Hit the road Jack", "A song made by Ray Charles", R.drawable.jack))
        list.add(Song("Jailrock house", "A song made by Elvis Presley", R.drawable.jail))
        list.add(Song("Starmen", "A song made by David Bowmen", R.drawable.david))

        adapter = SongAdapter() { song, position ->
            findNavController().navigate(
                SongListFragmentDirections.actionSongListFragmentToSongDetailFragment(
                    song.title,
                    song.description,
                    song.imageUrl
                )
            )
        }
        adapter.setList(list)
        binding.recyclerView.adapter = adapter
    }
}