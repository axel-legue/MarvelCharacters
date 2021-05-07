package com.axell.marvelcharacters.core.platform

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

abstract class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    override fun onStart() {
        super.onStart()
        onBind()
    }

    /**
     * Implement this method to implement the actual binding between viewModel and view
     *
     * Example:
     * onBind {
     *      viewModel.liveData.observe {
     *          view.doSomething(it)
     *      }
     *     view.click.observe {
     *          viewModel.doSomething()
     *      }
     * }
     */
    protected abstract fun onBind()

    /**
     * Use this method to bind an view element to a liveData
     *
     * Example:
     * viewModel.liveData.observe {
     *      view.doSomething(it)
     * }
     *
     * @param block The code executed on liveData change event
     */
    protected fun <T> LiveData<T>.observe(block: (t: T) -> Unit) {
        observe(
            viewLifecycleOwner,
            {
                block(it)
            }
        )
    }
}
