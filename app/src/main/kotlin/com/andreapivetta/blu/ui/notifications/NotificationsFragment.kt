package com.andreapivetta.blu.ui.notifications

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by andrea on 28/07/16.
 */
class NotificationsFragment : Fragment(), NotificationsMvpView {

    companion object {
        fun newInstance() = NotificationsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}