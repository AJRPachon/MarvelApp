package es.ajrpachon.comiclist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import es.ajrpachon.comiclist.databinding.CharacterComicListComicRowBinding
import es.ajrpachon.common.util.utils.getSecureUrl
import es.ajrpachon.data.model.charactercomic.CharacterComicBo

class CharacterComicListAdapter(private val callback: (Long) -> Unit) : ListAdapter<CharacterComicBo, CharacterComicListAdapter.CharacterComicViewHolder>(CharacterCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterComicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterComicViewHolder(CharacterComicListComicRowBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterComicListAdapter.CharacterComicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CharacterComicViewHolder(private val binding : CharacterComicListComicRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterComic: CharacterComicBo) {
            with(binding) {
                Glide.with(binding.root)
                    .load(getSecureUrl("${characterComic.image?.path}.${characterComic.image?.extension}"))
                    .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(characterComicListRowImgCharacterImg)

                this.characterComicListRowContainer.setOnClickListener {
                    callback(characterComic.id?.toLong() ?: 0L)
                }
            }
        }
    }


}

class CharacterCallBack : DiffUtil.ItemCallback<CharacterComicBo>() {
    override fun areItemsTheSame(oldItem: CharacterComicBo, newItem: CharacterComicBo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterComicBo, newItem: CharacterComicBo): Boolean {
        return oldItem == newItem
    }

}