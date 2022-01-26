@file:Suppress("DEPRECATION")

package cn.fkj233.xposed.statusbarlyric.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.fkj233.xposed.statusbarlyric.view.adapter.ItemAdapter
import cn.fkj233.xposed.statusbarlyric.view.data.DataHelper
import cn.fkj233.xposed.statusbarlyric.view.data.DataItem

class NewSettingsFragment : Fragment() {

    private var dataItem: DataItem? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
        RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ItemAdapter(DataHelper.getItems(if (dataItem == null) DataItem.Main else dataItem!!))
        }

    fun setDataItem(mDataItem: DataItem): NewSettingsFragment {
        dataItem = mDataItem
        return this
    }

}