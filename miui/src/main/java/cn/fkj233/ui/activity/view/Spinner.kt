package cn.fkj233.ui.activity.view

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import cn.fkj233.miui.R
import cn.fkj233.ui.activity.data.DataBinding
import cn.fkj233.ui.activity.data.LayoutPair
import cn.fkj233.ui.activity.data.MIUIPopupData
import cn.fkj233.ui.activity.dp2px
import cn.fkj233.ui.activity.sp2px

class Spinner(val arrayList: ArrayList<MIUIPopupData>, var currentValue: String, private val dataBindingRecv: DataBinding.Binding.Recv? = null): BaseView() {
    private lateinit var context: Context

    lateinit var select: TextView

    override fun getType(): BaseView = this

    override fun create(context: Context, callBacks: (() -> Unit)?): View {
        this.context = context
        return LinearContainerV(
            LinearContainerV.HORIZONTAL,
            arrayOf(
                LayoutPair(
                    TextView(context).also {
                        it.setPadding(0, 0, 0, dp2px(context, 15f))
                        it.textSize = sp2px(context, 5f)
                        it.text = currentValue
                        select = it
                    },
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).also {
                        it.gravity = Gravity.CENTER_VERTICAL + Gravity.RIGHT
                    }
                ),
                LayoutPair(
                    ImageView(context).also {
                        it.background = context.getDrawable(R.drawable.ic_up_down)
                    },
                    LinearLayout.LayoutParams(
                        dp2px(context, 20f),
                        dp2px(context, 20f)
                    )
                )
            ),
            descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS,
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        ).create(context, callBacks).also {
            dataBindingRecv?.setView(it)
        }
    }
}