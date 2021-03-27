package com.ahmettekin.horoscopeguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(
    private val context: Context,
    private val tumBurcBilgileri: ArrayList<Burc>
) : BaseAdapter() {



    override fun getCount(): Int {
        return tumBurcBilgileri.size
    }

    override fun getItem(position: Int): Any {
        return tumBurcBilgileri[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var tekSatirView = convertView
        val viewHolder2: ViewHolder2?


        if (tekSatirView == null) {
            tekSatirView = LayoutInflater.from(context).inflate(R.layout.tek_satir, parent, false)
            viewHolder2 = ViewHolder2(tekSatirView)

            tekSatirView.tag = viewHolder2

        } else {
            viewHolder2 = tekSatirView.tag as ViewHolder2
        }

        viewHolder2.burcAdi?.text = tumBurcBilgileri[position].burcAdi
        viewHolder2.burcResim?.setImageResource(tumBurcBilgileri[position].burcSembol)
        viewHolder2.burcTarih?.text = tumBurcBilgileri[position].burcTarih

        return tekSatirView
    }


}

class ViewHolder2(tekSatirview: View?) {

    var burcResim: ImageView?
    var burcAdi: TextView?
    var burcTarih: TextView?

    init {
        this.burcAdi = tekSatirview?.tvBurcAdi
        this.burcResim = tekSatirview?.imgBurcSembol
        this.burcTarih = tekSatirview?.tvBurcTarihi
    }
}