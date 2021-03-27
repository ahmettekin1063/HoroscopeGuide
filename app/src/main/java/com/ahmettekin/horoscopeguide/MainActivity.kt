package com.ahmettekin.horoscopeguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tek_satir.view.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var tumBurcBilgileri: ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veriKaynagiHazirla()
        window.statusBarColor=resources.getColor(R.color.teal_700)
        val burclar = resources.getStringArray(R.array.burclar)
        val burcTarihleri = resources.getStringArray(R.array.burcTarih)
        val burcResimleri = arrayOf(
            R.drawable.koc1,
            R.drawable.boga2,
            R.drawable.ikizler3,
            R.drawable.yengec4,
            R.drawable.aslan5,
            R.drawable.basak6,
            R.drawable.terazi7,
            R.drawable.akrep8,
            R.drawable.yay9,
            R.drawable.oglak10,
            R.drawable.kova11,
            R.drawable.balik12
        )

        //val myAdapter = ArrayAdapter(this, R.layout.tek_satir, R.id.tvBurcAdi, burclar)
        /*val myAdapter = BurclarArrayAdapter(
            this,
            R.layout.tek_satir,
            R.id.tvBurcAdi,
            burclar,
            burcTarihleri,
            burcResimleri
        )
        listBurclar.adapter = myAdapter*/

        val myBaseAdapter = BurclarBaseAdapter(this, tumBurcBilgileri)

        listBurclar.adapter = myBaseAdapter

        listBurclar.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, DetayActivity::class.java)
            intent.putExtra("nesne", tumBurcBilgileri[position])
            startActivity(intent)
        }
    }

    private fun veriKaynagiHazirla() {
        tumBurcBilgileri = ArrayList(12)

        val burcAdlari = resources.getStringArray(R.array.burclar)
        val burcTarihleri = resources.getStringArray(R.array.burcTarih)
        val burcResimleri = arrayOf(
            R.drawable.koc1,
            R.drawable.boga2,
            R.drawable.ikizler3,
            R.drawable.yengec4,
            R.drawable.aslan5,
            R.drawable.basak6,
            R.drawable.terazi7,
            R.drawable.akrep8,
            R.drawable.yay9,
            R.drawable.oglak10,
            R.drawable.kova11,
            R.drawable.balik12
        )

        val burcBuyukResimleri = arrayOf(
            R.drawable.koc_buyuk1,
            R.drawable.boga_buyuk2,
            R.drawable.ikizler_buyuk3,
            R.drawable.yengec_buyuk4,
            R.drawable.aslan_buyuk5,
            R.drawable.basak_buyuk6,
            R.drawable.terazi_buyuk7,
            R.drawable.akrep_buyuk8,
            R.drawable.yay_buyuk9,
            R.drawable.oglak_buyuk10,
            R.drawable.kova_buyuk11,
            R.drawable.balik_buyuk12
        )

        val burcGenelOzellikler = resources.getStringArray(R.array.burcGenelOzellikler)

        for (i in 0..11) {
            val arrayListeEklenecekBurc =
                Burc(
                    burcAdlari[i],
                    burcTarihleri[i],
                    burcResimleri[i],
                    burcBuyukResimleri[i],
                    burcGenelOzellikler[i]
                )

            tumBurcBilgileri.add(arrayListeEklenecekBurc)
        }
    }
}