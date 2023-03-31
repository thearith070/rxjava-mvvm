package thearith.rxjavamvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import thearith.rxjavamvvm.databinding.ItemPostsBinding
import thearith.rxjavamvvm.model.PostItem
import javax.inject.Inject

class PostsAdapter @Inject constructor() :
    ListAdapter<PostItem, PostsAdapter.PostViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostsBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindItem(position)
    }

    inner class PostViewHolder(
        private val binding: ItemPostsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(position: Int) {
            binding.root.isSelected = position % 2 == 0
            binding.tvTitle.text = getItem(position).title
        }
    }

    companion object {

        private val COMPARATOR = object : DiffUtil.ItemCallback<PostItem>() {
            override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
                return oldItem == newItem
            }

        }

    }

}