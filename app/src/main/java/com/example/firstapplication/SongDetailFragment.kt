package com.example.firstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firstapplication.databinding.FragmentSongDetailBinding

class SongDetailFragment : Fragment() {

    lateinit var binding: FragmentSongDetailBinding

    val args: SongDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.description)
        val img = view.findViewById<ImageView>(R.id.img)

        val string1 = args.title
        val string2 = args.description
        val img1 = args.image

        title.text = string1
        description.text = string2
        img.setImageResource(img1)

        val button = view.findViewById<Button>(R.id.buttonTo1)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_songDetailFragment_to_songListFragment)
        }
    }
}