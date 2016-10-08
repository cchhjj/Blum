package com.andreapivetta.blu.ui.newtweet

import android.content.Context
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import com.andreapivetta.blu.R
import com.andreapivetta.blu.common.utils.Utils
import kotlinx.android.synthetic.main.photo_deletable.view.*
import java.io.File

/**
 * Created by andrea on 29/05/16.
 */
class DeletableImageAdapter(val context: Context, val imageFiles: MutableList<File>) :
        RecyclerView.Adapter<DeletableImageAdapter.Companion.DeletableImageViewHolder>() {

    companion object {
        class DeletableImageViewHolder(root: View) : RecyclerView.ViewHolder(root) {
            val photoImageView: ImageView = root.tweetPhotoImageView
            val deleteButton: ImageButton = root.deleteButton
        }
    }

    override fun onBindViewHolder(holder: DeletableImageViewHolder?, position: Int) {
        holder?.photoImageView?.setImageBitmap(ThumbnailUtils.extractThumbnail(BitmapFactory
                .decodeFile(imageFiles[position].absolutePath),
                Utils.dpToPx(context, 200), Utils.dpToPx(context, 200)))
        holder?.deleteButton?.setOnClickListener {
            imageFiles.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = DeletableImageViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.photo_deletable, parent, false))

    override fun getItemCount() = imageFiles.size
}