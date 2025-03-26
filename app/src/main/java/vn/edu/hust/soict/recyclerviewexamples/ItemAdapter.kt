package vn.edu.hust.soict.recyclerviewexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.soict.recyclerviewexamples.ItemAdapter.ItemViewHolder

class ItemAdapter(val items: List<ItemModel>,
                  val listener: ItemClickListener? = null,
                  val deleteListener: DeleteItemListener? = null,
  ): RecyclerView.Adapter<ItemViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
    return ItemViewHolder(itemView, listener, deleteListener)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item = items[position]
    holder.textHoten.text = item.hoten
    holder.textMssv.text = item.mssv
  }

  override fun getItemCount() = items.size

  class ItemViewHolder(itemView: View,
                       val listener: ItemClickListener? = null,
                       val deleteListener: DeleteItemListener? = null,): RecyclerView.ViewHolder(itemView) {
    val textHoten = itemView.findViewById<TextView>(R.id.text_hoten)
    val textMssv = itemView.findViewById<TextView>(R.id.text_mssv)
    val imageDelete = itemView.findViewById<ImageView>(R.id.image_delete)
    init {
      itemView.setOnClickListener {
        listener?.onItemClicked(adapterPosition)
      }
      imageDelete.setOnClickListener {
        deleteListener?.onItemSelected(adapterPosition)
      }
    }
  }


}