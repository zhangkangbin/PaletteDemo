package com.z.palette.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.z.palette.R
import com.z.palette.app.LoadImageEngine
import com.z.palette.bean.ThemeDataSaveBean

/**
 * @author by zhangkangbin
 * on 2020/5/12
 * 界面说明
 */
class ThemeLocalListAdapter(private val mThemeDataSaveBean: List<ThemeDataSaveBean>) : RecyclerView.Adapter<ThemeLocalListAdapter.ViewHolder>() {


    private var context: Context? = null

    fun setSelectClickListener(selectImage: OnClickListener<ThemeDataSaveBean>?) {
        this.selectImage = selectImage
    }

    private var selectImage: OnClickListener<ThemeDataSaveBean> ? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        context = viewGroup.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_local_list, viewGroup, false))
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.theme.setText(mThemeDataSaveBean[i].theme)
        context?.let {

            if(mThemeDataSaveBean[i].imagePathList?.size!!<2){
                return
            }


            Glide.with(it).load( mThemeDataSaveBean[i].imagePathList?.get(1)).into(viewHolder.image) }
        viewHolder.linearLayout.setOnClickListener {
            selectImage?.callData(mThemeDataSaveBean[i])
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val theme = itemView.findViewById<TextView>(R.id.text)
        val linearLayout = itemView.findViewById<View>(R.id.linearLayout)

    }

    override fun getItemCount(): Int {
        return mThemeDataSaveBean.size
    }

    interface OnClickListener<T> {
        fun callData(data: T?)
    }
}

