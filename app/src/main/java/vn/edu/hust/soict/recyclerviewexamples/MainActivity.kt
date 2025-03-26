package vn.edu.hust.soict.recyclerviewexamples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  var selectedPosition = -1
  lateinit var adapter: ItemAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val items = mutableListOf<ItemModel>()
    repeat(50) {
      items.add(ItemModel("Student $it", "SV$it"))
    }

    val editHoten = findViewById<EditText>(R.id.edit_hoten)
    val editMssv = findViewById<EditText>(R.id.edit_mssv)

    adapter = ItemAdapter(items, object : ItemClickListener {
      override fun onItemClicked(position: Int) {
        selectedPosition = position
        val selectedItem = items[position]
        editHoten.setText(selectedItem.hoten)
        editMssv.setText(selectedItem.mssv)
      }
    }, object : DeleteItemListener {
      override fun onItemSelected(position: Int) {
        items.removeAt(position)
        adapter.notifyItemRemoved(position)
      }
    })

    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    findViewById<Button>(R.id.button_add).setOnClickListener {
      val hoten = editHoten.text.toString()
      val mssv = editMssv.text.toString()
      val item = ItemModel(hoten, mssv)
      items.add(0, item)
      adapter.notifyItemInserted(0)
      recyclerView.scrollToPosition(0)
    }

    findViewById<Button>(R.id.button_update).setOnClickListener {
      val hoten = editHoten.text.toString()
      val mssv = editMssv.text.toString()
      if (selectedPosition != -1) {
        items[selectedPosition].hoten = hoten
        items[selectedPosition].mssv = mssv
        adapter.notifyItemChanged(selectedPosition)
      }
    }
  }

}