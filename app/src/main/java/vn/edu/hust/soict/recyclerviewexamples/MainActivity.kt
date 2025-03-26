package vn.edu.hust.soict.recyclerviewexamples

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val items = mutableListOf<ItemModel>(
      ItemModel(R.drawable.thumb0, "Item 0"),
      ItemModel(R.drawable.thumb1, "Item 1"),
      ItemModel(R.drawable.thumb2, "Item 2"),
      ItemModel(R.drawable.thumb3, "Item 3"),
      ItemModel(R.drawable.thumb4, "Item 4"),
      ItemModel(R.drawable.thumb5, "Item 5"),
      ItemModel(R.drawable.thumb6, "Item 6"),
      ItemModel(R.drawable.thumb7, "Item 7"),
      ItemModel(R.drawable.thumb8, "Item 8"),
      ItemModel(R.drawable.thumb9, "Item 9"),
    )

    val adapter = ItemAdapter(items, object : ItemClickListener {
      override fun onItemClicked(position: Int) {

      }
    })

    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    findViewById<Button>(R.id.button_add).setOnClickListener {
      items.add(1, ItemModel(R.drawable.thumb10, "New Item"))
      adapter.notifyItemInserted(1)
    }

    findViewById<Button>(R.id.button_remove).setOnClickListener {
      items.removeAt(1)
      adapter.notifyItemRemoved(1)
    }

    findViewById<Button>(R.id.button_update).setOnClickListener {
      items[1].title = "Updated Item"
      adapter.notifyItemChanged(1)
    }
  }

  fun onItemClicked(position: Int) {

  }

}