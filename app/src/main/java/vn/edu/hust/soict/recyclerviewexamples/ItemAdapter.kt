package vn.edu.hust.soict.recyclerviewexamples

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.soict.recyclerviewexamples.ItemAdapter.ItemViewHolder

class ItemAdapter(val items: List<ItemModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<ItemViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
    return ItemViewHolder(itemView, listener)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item = items[position]
    holder.imageView.setImageResource(item.imageId)
    holder.textView.text = item.title
  }

  override fun getItemCount() = items.size

  class ItemViewHolder(itemView: View, val listener: ItemClickListener? = null): RecyclerView.ViewHolder(itemView) {
    val imageView = itemView.findViewById<ImageView>(R.id.image_view)
    val textView = itemView.findViewById<TextView>(R.id.text_view)
    init {
      itemView.setOnClickListener {
        listener?.onItemClicked(adapterPosition)
      }
    }
  }


}