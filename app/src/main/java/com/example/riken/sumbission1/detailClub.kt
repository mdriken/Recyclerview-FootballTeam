package com.example.riken.sumbission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*


class DetailClubActivity : AppCompatActivity() {


    private var name: String = ""
    private var image: Int = 0

    lateinit var nameTextView: TextView
    lateinit var detailClub: TextView
    lateinit var gambarClub: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)


            gambarClub = imageView {
            }.lparams(width = 250, height = 250) {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(15)

            }
            nameTextView = textView {
                gravity = Gravity.CENTER
                textSize = 16f

            }
            detailClub = textView {
                gravity = Gravity.CENTER_HORIZONTAL
            }

        }

        val intent = intent
        image = intent.getIntExtra("image",0)
        name = intent.getStringExtra("name")
        nameTextView.text = name
        val detail = intent.getStringExtra("detail")
        detailClub.text = detail
        Glide.with(this).load(image).into(gambarClub)
    }
}
