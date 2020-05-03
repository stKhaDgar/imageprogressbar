package com.stmaktavish.imageprogressbar.utils

import android.content.res.Resources


object Utils {
    fun dp2px(resources: Resources, dp: Float): Float {
        val scale: Float = resources.displayMetrics.density
        return dp * scale + 0.5f
    }

    fun sp2px(resources: Resources, sp: Float): Float {
        val scale: Float = resources.displayMetrics.scaledDensity
        return sp * scale
    }
}