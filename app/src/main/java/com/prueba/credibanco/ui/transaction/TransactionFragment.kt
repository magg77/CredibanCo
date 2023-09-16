package com.prueba.credibanco.ui.transaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.server.DataSourceRemoteImpl
import com.prueba.credibanco.data.repository.RepoImpl
import com.prueba.credibanco.databinding.FragmentTransactionBinding
import com.prueba.credibanco.domain.TransactionUseCase
import com.prueba.credibanco.presentation.TransactionViewModel
import com.prueba.credibanco.presentation.VMFactory
import dagger.hilt.android.AndroidEntryPoint

class TransactionFragment : Fragment() {

    private var _binding: FragmentTransactionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModelTransaction by viewModels<TransactionViewModel>{
        VMFactory(
            TransactionUseCase(
                RepoImpl(
                    DataSourceRemoteImpl()
                )
            )
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupObservers() {
        viewModelTransaction.setFilterTransaction(
            AuthorizationRequest(
                "001",
                "000123",
                "000ABC",
                "12345",
                "1234567890123456"
            )
        ).observe(viewLifecycleOwner, Observer {

            when (it) {
                is Resource.Loading -> {
                    //binding.progressbarHome.visibility = View.VISIBLE
                    Log.i("result", "cargando")
                }

                is Resource.Success -> {
                    //binding.progressbarHome.visibility = View.GONE
                    Log.i("result", "${it.data}")
                }

                is Resource.Failure -> {
                    //binding.progressbarHome.visibility = View.GONE

                    Log.e("result0", "${it.exception}")
                    Toast.makeText(
                        requireContext(),
                        "Ocurrio un error al traer los datos: ${it.exception}",
                        Toast.LENGTH_LONG
                    ).show()
                }


            }

        })

    }


}