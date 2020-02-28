package com.example.demomvvmgraphql.binding.interfacebinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestListener


interface ImageViewBindingAdapters {
    @BindingAdapter(value = ["imageUrl"], requireAll = false)
    fun bindImage(imageView: ImageView, imageUrl: String?);

//    @BindingAdapter(value = ["room", "requestListener"], requireAll = false)
//    fun bindImage(imageView: ImageView, room: Room?, listener: RequestListener<Drawable?>?);
//
//    @BindingAdapter(value = ["publicRoom", "requestListener"], requireAll = false)
//    fun bindImage(imageView: ImageView, room: PublicRoom?, listener: RequestListener<Drawable?>?);
//
//    @BindingAdapter(value = ["user", "requestListener"], requireAll = false)
//    fun bindImage(imageView: ImageView, user: User?, listener: RequestListener<Drawable?>?);
//
//    @BindingAdapter(value = ["status"], requireAll = false)
//    fun bindStatus(imageView: ImageView, status: Byte?)
//
//    @BindingAdapter(value = ["encrypted"], requireAll = false)
//    fun bindEncrypted(imageView: ImageView, encrypted: Byte?)
//
//    @BindingAdapter(value = ["validStatus"], requireAll = false)
//    fun bindStatusValid(imageView: ImageView, validStatus: Byte?)
//
//    @BindingAdapter(value = ["listUser", "currentUserId"], requireAll = false)
//    fun bindStatusFromListUser(imageView: ImageView, users: List<User>?, currentUserId: String?)
//
//    @BindingAdapter(value = ["imageFile"], requireAll = false)
//    fun bindImageFile(imageView: ImageView, fileContent: ImageMessage)
//
//    @BindingAdapter(value = ["showImagePlayer"], requireAll = false)
//    fun bindShowImagePlayer(imageView: ImageView, fileContent: ImageMessage)
}