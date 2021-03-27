package com.ahmettekin.horoscopeguide

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*


class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        val myBurc = intent.extras?.getSerializable("nesne") as Burc
        tvBurcOzellikleri.text = myBurc.burcGenelOzellikleri
        header.setImageResource(myBurc.burcBuyukResim)

        setSupportActionBar(anim_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = myBurc.burcAdi

        val bitmap = BitmapFactory.decodeResource(resources, myBurc.burcBuyukResim)

        Palette.from(bitmap).generate {
            val darkVibrantColor: Int = it!!.getDarkVibrantColor(R.attr.colorAccent)
            collapsing_toolbar.setContentScrimColor(darkVibrantColor)
            window.statusBarColor = darkVibrantColor
        }
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }*/

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
