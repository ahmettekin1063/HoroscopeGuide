package com.ahmettekin.horoscopeguide

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarArrayAdapter(
    var mContext: Context,
    var resource: Int,
    textViewResourceId: Int,
    var burcAdlari: Array<String>,
    var burcTarihleri: Array<String>,
    var burcResimleri: Array<Int>
) : ArrayAdapter<String>(mContext, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tekSatirView = convertView
        val viewHolder: ViewHolder

        if (tekSatirView == null) {
            tekSatirView = LayoutInflater.from(mContext).inflate(resource, parent, false)
            viewHolder = ViewHolder(tekSatirView)
            tekSatirView.tag = viewHolder
        } else {
            viewHolder = tekSatirView.tag as ViewHolder
        }

        /**
         * Burada aslında convertView başlangıçta null idi.
         * Daha sonra bu adapteri kullanan listView ekranda oynayınca convertView 'a koyuldu.
         * Artık tekrar tekrar inflate edilmesine gerek kalmadı.
         */

        viewHolder.burcResim.setImageResource(burcResimleri[position])
        viewHolder.burcAdi.text = burcAdlari[position]
        viewHolder.burcTarih.text = burcTarihleri[position]
        return tekSatirView!!

    }

    class ViewHolder(tekSatirView: View) {

        var burcResim: ImageView
        var burcAdi: TextView
        var burcTarih: TextView

        init {
            this.burcResim = tekSatirView.imgBurcSembol
            this.burcAdi = tekSatirView.tvBurcAdi
            this.burcTarih = tekSatirView.tvBurcTarihi
        }
    }
}