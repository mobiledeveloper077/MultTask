package uz.abduvali.multtask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.domain.models.Result
import uz.abduvali.multtask.databinding.ItemCharacterBinding
import uz.abduvali.multtask.utils.setImage
import uz.abduvali.multtask.utils.toCharacterEntity

class CharacterAdapter(private val onItemClick: OnItemClick) :
    PagingDataAdapter<Result, CharacterAdapter.Vh>(DiffUtil()) {

    interface OnItemClick {
        fun onClick(characterEntity: CharacterEntity)
    }

    class Vh(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val item = getItem(position)?.toCharacterEntity()!!
        holder.binding.apply {
            root.setOnClickListener { onItemClick.onClick(item) }
            image.setImage(item.image)
            name.text = item.name
            location.text = item.location
            status.text = item.status
        }
    }
}