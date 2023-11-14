import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapplication.Song
import com.example.firstapplication.databinding.ItemSongBinding

class SongAdapter(
    val onClick: (song: Song, position: Int) -> Unit
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private val list = ArrayList<Song>()

    fun setList(newList: List<Song>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class SongViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(element: Song, position: Int) {
            binding.Title.text = element.title
            binding.Description.text = element.description
            binding.btn.setOnClickListener {
                onClick(element, position)
            }

            Glide.with(binding.iv1.context)
                .load(element.imageUrl)
                .into(binding.iv1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element, position)
    }

}