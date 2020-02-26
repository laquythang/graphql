package com.example.demomvvmgraphql.binding

import androidx.databinding.DataBindingComponent
import com.example.demomvvmgraphql.binding.interfacebinding.ImageViewBindingAdapters
import com.example.demomvvmgraphql.binding.interfacebinding.TextViewBindingAdapters
import com.example.demomvvmgraphql.binding.interfacebinding.ViewBindingAdapters
import javax.inject.Inject

class DataBindingComponentImplement @Inject constructor(private val bindingAdapters: BindingAdaptersImplement) :
    DataBindingComponent, IDataBindingComponent {
    override fun getTextViewBindingAdapters(): TextViewBindingAdapters {
        return bindingAdapters
    }

    override fun getViewBindingAdapters(): ViewBindingAdapters {
        return bindingAdapters
    }

    override fun getImageViewBindingAdapters(): ImageViewBindingAdapters {
        return bindingAdapters
    }

    override fun getDataBindingComponent(): DataBindingComponent {
        return this
    }
}