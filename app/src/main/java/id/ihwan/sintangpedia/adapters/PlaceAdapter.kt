package id.ihwan.sintangpedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.sintangpedia.Place
import id.ihwan.sintangpedia.databinding.ListItemPlaceBinding

/**
 * Adapter for the [RecyclerView] in [PlaceListFragment].
 */
class PlaceAdapter: ListAdapter<Place, RecyclerView.ViewHolder>(PlaceDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlaceViewHolder(ListItemPlaceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val place = getItem(position)
        (holder as PlaceViewHolder).bind(place)
    }

    class PlaceViewHolder(
        private val binding: ListItemPlaceBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Place){
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }

}

private class PlaceDiffCallback: DiffUtil.ItemCallback<Place>(){

    override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
        return oldItem == newItem
    }

}