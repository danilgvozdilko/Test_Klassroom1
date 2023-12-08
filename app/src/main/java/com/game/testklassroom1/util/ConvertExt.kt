package com.game.testklassroom1.util

import android.content.Context
import android.util.TypedValue

fun Context.dp(value: Int): Float = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    value.toFloat(),
    resources.displayMetrics
)