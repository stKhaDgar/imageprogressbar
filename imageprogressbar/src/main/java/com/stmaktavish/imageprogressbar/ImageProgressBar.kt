package com.stmaktavish.imageprogressbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView


class ImageProgressBar @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val ivImage: ImageView
    private val arcProgressBar: ArcProgressBar
    private val tvProgress: TextView

    var progress: Float = 0F
        set(value) {
            when {
                value > 0 && value <= 100 -> {
                    arcProgressBar.progress = value
                    tvProgress.text = "${value.toInt()}%"
                    field = value
                }
                value > 100 -> {
                    arcProgressBar.progress = 100F
                    tvProgress.text = "100%"
                    field = 100F
                }
                value <= 0 -> {
                    arcProgressBar.progress = 0F
                    tvProgress.text = "0%"
                    field = 0F
                }
            }
        }

    init {
        val layout = LayoutInflater.from(context).inflate(R.layout.image_progress_bar_layout, null)
        addView(layout)

        ivImage = layout.findViewById(R.id.ivImage)
        arcProgressBar = layout.findViewById(R.id.arcProgressBar)
        tvProgress = layout.findViewById(R.id.tvProgress)

        initAttrs()
    }

    private fun initAttrs() {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ImageProgressBar, 0, 0)

            val progress = typedArray.getFloat(R.styleable.ImageProgressBar_progress, 0F)
            val image = typedArray.getResourceId(R.styleable.ImageProgressBar_image, 0)

            this.progress = progress
            setImage(image)

            typedArray.recycle()
        }
    }

    fun setImage(image: Int) {
        if (image != 0) {
            ivImage.setImageResource(image)
        }
    }

}