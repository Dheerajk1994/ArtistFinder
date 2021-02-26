package com.example.artistfinder.databinding

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

@BindingAdapter("boundVisibility")
fun bindViewVisibility(view: View, visibility: LiveData<Int>?) {
    val parent = view.getParentActivity()
    if (parent != null && visibility != null) {
        visibility.observe(parent, Observer {
            view.visibility = it ?: View.INVISIBLE
        })
    }
}