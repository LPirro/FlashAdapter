package com.lpirro.flashadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.lpirro.flashadapter.interfaces.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnRecyclerItemClickListener {


    private lateinit var adapter: FlashSampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = FlashSampleAdapter(this, this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.setItems(generateMockUsers())
    }

    override fun onItemClick(position: Int) {
        val name = adapter.getItem(position).name
        Toast.makeText(this, "Clicked: $name", Toast.LENGTH_LONG).show()
    }

    private fun generateMockUsers(): List<User>{
        val user1 = User("User 1")
        val user2 = User("User 2")
        val user3 = User("User 3")

        val items = ArrayList<User>()
        items.add(user1)
        items.add(user2)
        items.add(user3)

        return  items
    }
}