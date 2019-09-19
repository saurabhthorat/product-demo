package com.saurabh.demo.ui.edit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.api.load
import com.saurabh.demo.R
import com.saurabh.demo.data.network.entities.Product
import kotlinx.android.synthetic.main.fragment_edit.*
import org.koin.android.viewmodel.ext.android.viewModel

class EditFragment : Fragment(R.layout.fragment_edit) {

    private val viewModel: EditViewModel by viewModel()
    val product: Product by lazy {
        arguments?.getSerializable(PRODUCT) as Product
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFields()

        btnEditSave.setOnClickListener {
            viewModel.saveProduct(
                product,
                etEditName.text.toString(),
                etEditCompany.text.toString(),
                etEditPrice.text.toString()
            )

            Toast.makeText(activity, "Product edited!", Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager!!.popBackStack()
        }
    }

    private fun initFields() {
        ivEdit.load(product.image)
        etEditName.setText(product.productName)
        etEditCompany.setText(product.company)
        etEditPrice.setText(product.price)
    }

    companion object {
        private const val PRODUCT = "product"
        fun forProduct(product: Product): EditFragment {
            val fragment = EditFragment()
            fragment.arguments = Bundle().apply {
                putSerializable(PRODUCT, product)
            }
            return fragment
        }
    }
}