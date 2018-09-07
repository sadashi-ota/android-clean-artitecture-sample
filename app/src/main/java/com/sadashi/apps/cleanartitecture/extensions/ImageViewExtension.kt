package com.sadashi.apps.cleanartitecture.extensions

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun ImageView.imageUrl(url: String?) {
    if (TextUtils.isEmpty(url)) {
        setImageDrawable(null)
        return
    }
    Picasso.with(context).load(url).into(this)
}
