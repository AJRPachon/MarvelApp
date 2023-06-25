package es.ajrpachon.characterlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import es.ajrpachon.characterlist.R
import es.ajrpachon.characterlist.databinding.CharacterListCharacterRowBinding
import es.ajrpachon.data.model.character.CharacterBo

class CharacterListAdapter : ListAdapter<CharacterBo, CharacterListAdapter.CharacterViewHolder>(CharacterCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(CharacterListCharacterRowBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterListAdapter.CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CharacterViewHolder(private val binding : CharacterListCharacterRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterBo) {
            binding.let {
                with(it) {
                    characterListRowLblCharacterName.text = character.name

                    Glide.with(binding.root)
                        .load(character.image)
                        .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(characterListRowImgCharacterImg)
                }
            }
        }
    }


}

class CharacterCallBack : DiffUtil.ItemCallback<CharacterBo>() {
    override fun areItemsTheSame(oldItem: CharacterBo, newItem: CharacterBo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterBo, newItem: CharacterBo): Boolean {
        return oldItem == newItem
    }

}