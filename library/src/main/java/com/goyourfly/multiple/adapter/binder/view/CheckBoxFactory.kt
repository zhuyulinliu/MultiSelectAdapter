package com.goyourfly.multiple.adapter.binder.view

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

/**
 * Created by gaoyufei on 2017/6/11.
 */

class CheckBoxFactory(val color: Int = Color.RED, val duration: Int = 300) : CustomViewFactory() {
    override fun onShowAnimation(itemView: View, selectView: View) {
        selectView.visibility = View.VISIBLE
    }

    override fun onHideAnimation(itemView: View, selectView: View) {
        selectView.visibility = View.GONE
    }

    override fun onCreateSelectView(context: android.content.Context): View {
        val imageView = android.widget.ImageView(context)
        imageView.setImageResource(com.goyourfly.multiple.adapter.R.drawable.ic_check_box_black_24dp)
        imageView.setColorFilter(color)
        return imageView
    }

    override fun onCreateNormalView(context: android.content.Context): View {
        val imageView = android.widget.ImageView(context)
        imageView.setColorFilter(color)
        imageView.setImageResource(com.goyourfly.multiple.adapter.R.drawable.ic_check_box_outline_blank_black_24dp)
        return imageView
    }

    override fun onCreateRootView(context: android.content.Context): ViewGroup {
        return FrameLayout(context)
    }

    override fun onBindSelectView(root: ViewGroup, itemView: View, selectView: View) {
        root.removeAllViews()
        root.addView(itemView)
        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.RIGHT
        params.topMargin = 8.toPx(root.context)
        params.rightMargin = 8.toPx(root.context)
        root.addView(selectView, params)
    }

}