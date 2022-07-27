package com.polinasmogi.viewpager.ui.widgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.*
import com.polinasmogi.viewpager.R

class SubtitledRadioButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :  RelativeLayout(context, attrs, defStyleAttr), Checkable {

    private val touchListener = View.OnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_UP -> {
                isChecked = true
                performClick()
            }
        }
        true
    }

    private val titleTextView: TextView by lazy { findViewById(R.id.title) }
    private val subtitleTextView: TextView by lazy { findViewById(R.id.subtitle) }
    private val radioButton: RadioButton by lazy { findViewById(R.id.radio_button) }

    private var onCheckedChangeListener: OnCheckedChangeListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.radio_button, this, true)
        setOnTouchListener(touchListener)

        val attr = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ControlView,
            0,
            0
        )

        try {
            setupAttributes(attr)
        } finally {
            attr.recycle()
        }
    }

    private fun setupAttributes(attr: TypedArray) {
        titleTextView.text = attr.getString(R.styleable.ControlView_title)
        subtitleTextView.text = attr.getString(R.styleable.ControlView_subtitle)
    }

    fun setOnCheckedChangeListener(listener: OnCheckedChangeListener?) {
        onCheckedChangeListener = listener
    }

    override fun setChecked(checked: Boolean) {
        radioButton.isChecked = checked
        onCheckedChangeListener?.onCheckedChanged(this, checked)
    }

    override fun isChecked(): Boolean = radioButton.isChecked

    override fun toggle() {
        isChecked = !isChecked
    }

    interface OnCheckedChangeListener {
        fun onCheckedChanged(view: SubtitledRadioButton, isChecked: Boolean)
    }

}