package com.polinasmogi.viewpager.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup

class RadioGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RadioGroup(context, attrs), SubtitledRadioButton.OnCheckedChangeListener {
    private var checkedChangeListener: RadioGroup.OnCheckedChangeListener? = null
    var checkedId: Int? = null; private set

    override fun onCheckedChanged(view: SubtitledRadioButton, isChecked: Boolean) {
        if (isChecked) {
            view.setOnCheckedChangeListener(null)
            check(view.id)
            view.setOnCheckedChangeListener(this)
        }
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if (child is SubtitledRadioButton) {
            child.setOnCheckedChangeListener(this)
        }

        super.addView(child, index, params)
    }

    override fun check(id: Int) {
        if (id != -1 && id == checkedId) {
            return
        }

        if (checkedId != null && checkedId != -1) {
            setCheckedStateForView(checkedId, false)
        }

        if (id != -1) {
            setCheckedStateForView(id, true)
        }

        checkedId = id
        checkedChangeListener?.onCheckedChanged(this, id)
    }

    private fun setCheckedStateForView(viewId: Int?, checked: Boolean) {
        if (viewId == null) {
            return
        }

        val targetView = findViewById<View>(viewId)

        if (targetView != null && targetView is SubtitledRadioButton) {
            targetView.isChecked = checked
        }
    }

    override fun setOnCheckedChangeListener(listener: OnCheckedChangeListener) {
        checkedChangeListener = listener
    }

    override fun getCheckedRadioButtonId(): Int {
        return checkedId ?: -1
    }
}