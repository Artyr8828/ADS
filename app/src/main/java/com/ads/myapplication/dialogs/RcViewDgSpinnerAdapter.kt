package com.ads.myapplication.dialogs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ads.myapplication.R
import com.ads.myapplication.act.EditAdsAct

/**
 * var context: Context
 * если указавыем var, то context будет доступе в классе
 * если не указывает var, то context надо будет обьявить в свойствах(private val cont = context)
 */
class RcViewDgSpinnerAdapter(var context: Context, var dialog:AlertDialog): RecyclerView.Adapter<RcViewDgSpinnerAdapter.SpViewHolder>() {
  private val mainList = ArrayList<String>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.sp_list_item, parent, false)

    return SpViewHolder(view, context, dialog)
  }

  override fun onBindViewHolder(holder: SpViewHolder, position: Int) {
    holder.setData(mainList[position])
  }

  override fun getItemCount(): Int {
    return mainList.size
  }

  class SpViewHolder(itemView: View, var context: Context, var dialog: AlertDialog, ): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private var itemText = ""

    fun setData(text: String) {
      val tvSpItem = itemView.findViewById<TextView>(R.id.tvSpItem)

      tvSpItem.text = text

      itemText = text

      itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
      // Превращаем context в EditAdsAct
      (context as EditAdsAct).rootElement.tvCountry.text = itemText
      dialog.dismiss()
    }
  }

  @SuppressLint("NotifyDataSetChanged")
  fun updateAdapter(list: ArrayList<String>) {
    mainList.clear()
    mainList.addAll(list)

    notifyDataSetChanged()
  }
}

