package com.saurabh.demo.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabh.demo.R
import com.saurabh.demo.data.network.entities.Product
import com.saurabh.demo.ui.edit.EditFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HomeAdapter(object : HomeAdapter.OnProductClickListener {
            override fun onProductClick(product: Product) {
                activity?.supportFragmentManager!!
                    .beginTransaction()
                    .replace(R.id.container, EditFragment.forProduct(product))
                    .addToBackStack(null)
                    .commit()
            }
        })
        rvHome.adapter = adapter
        rvHome.layoutManager = LinearLayoutManager(context)

        viewModel.products.observe(this, Observer(adapter::submitList))
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}