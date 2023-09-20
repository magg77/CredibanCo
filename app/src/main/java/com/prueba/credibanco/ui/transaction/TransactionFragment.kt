package com.prueba.credibanco.ui.transaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.prueba.credibanco.R
import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.databinding.FragmentTransactionBinding
import com.prueba.credibanco.presentation.TransactionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionFragment : Fragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!
    private val viewModelTransaction by viewModels<TransactionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        eventsClick()

    }

    override fun onResume() {
        super.onResume()

        requireActivity().onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!findNavController().navigateUp()) {
                        if (isEnabled) {
                            Log.i("back", "00000  atras dialog")
                            isEnabled = false
                            requireActivity().onBackPressedDispatcher.onBackPressed()
                        }
                        Log.i("back", "111  atras dialog")
                    } else {
                        var prueba = "falso"
                        Log.i("back", "2222 atras dialog")
                    }
                    Log.i("back", "atras dialog")
                }
            }
        )

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
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

    }

    private fun eventsClick() {
        binding.mbCreateTransactionFragment.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_transaction_to_createTransactionFragment)

            /*findNavController().addOnDestinationChangedListener { _, destination, _ ->
                //(activity as AppCompatActivity?)!!
            }*/

            /*val navHost = NavHostFragment()
            childFragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main, navHost).commitNow()
            navHost.navController.setGraph(R.navigation.mobile_navigation)*/

        }


    }


}