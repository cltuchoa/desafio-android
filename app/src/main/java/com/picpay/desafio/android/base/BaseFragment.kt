package com.picpay.desafio.android.base

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.user_detail_fragment.*

abstract class BaseFragment : Fragment() {

    fun toggleVisibility(
        isLoading: Boolean,
        shouldHide: Boolean = false,
        reverse: Boolean = false
    ) = when (isLoading) {
        true -> if (!reverse) View.VISIBLE else {
            if (shouldHide) View.INVISIBLE else View.GONE
        }
        false -> if (!reverse) {
            if (shouldHide) View.INVISIBLE else View.GONE
        } else View.VISIBLE
    }

    fun handleError(throwable: Throwable) {
        view?.let {
            progressBar.visibility = View.GONE
            Snackbar.make(it, throwable.message ?: "", Snackbar.LENGTH_LONG).show()
        }
    }
}
