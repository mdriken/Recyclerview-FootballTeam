package com.example.riken.sumbission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        clubList.layoutManager = LinearLayoutManager(this)
        clubList.adapter = RecyclerViewAdapter(this, items) {


            alert("Pilih salah satu!", "Apakah anda yakin memilih, ${it.name}?") {
                val gambar = it.image
                val info = it.desc
                val infox = info.toString()
                val nama = it.name
                val namax = nama.toString()
                yesButton {
                    startActivity<DetailClubActivity>(
                        "name" to "${namax}",
                        "image" to gambar,
                        "detail" to "${infox}"
                    )
                }
                noButton { toast("Silakan Pilih Kembali") }
            }.show()

        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val detail = resources.getStringArray(R.array.club_info)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in name.indices) {
                items.add(Item(name[i], image.getResourceId(i, 0), detail[i]))
        }

        image.recycle()
    }
}
