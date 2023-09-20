package com.prueba.credibanco.ui.transaction

import android.app.Dialog
import android.content.ContextWrapper
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import com.prueba.credibanco.R
import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.presentation.TransactionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTransactionFragment : DialogFragment() {

    /*private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!*/

    private val viewModelTransaction by viewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        isCancelable = false
        val viewLayout: View =
            inflater.inflate(R.layout.fragment_create_transaction, container, false)


        return viewLayout

        /*_binding = FragmentTransactionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root*/
    }

    /*override fun getTheme(): Int {
        return R.style.DialogTheme
    }*/

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)

        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog

        /*val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Probando Full-screen dialog")
            .setPositiveButton("Crear Transaccion",
                DialogInterface.OnClickListener { dialog, id ->
                    // START THE GAME!
                })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })

        builder.create()
        return builder*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val buttonCreateTransaction: Button = view.findViewById(R.id.button) as Button
        buttonCreateTransaction.setOnClickListener {
            createTransaction()
        }

        (dialog as androidx.activity.ComponentDialog)
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
                //findNavController().navigateUp()
                dismiss()
            }


        val toolbar: MaterialToolbar =
            view.findViewById(R.id.materialToolbar_createTransaction) as MaterialToolbar

        //(context as AppCompatActivity).setSupportActionBar(toolbar)
        val context = (context as ContextWrapper).baseContext
        (context as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        toolbar.setNavigationOnClickListener {
            dismiss()
        }

        /*dialog?.setOnKeyListener { _, keyCode, event ->
            Log.i("keyCode", "fjakdsfjalks")
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                requireActivity().onBackPressed()
                Log.i("keyCode", "fjakdsfjalks")
                return@setOnKeyListener true
            }
            false
        }*/
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_create_transaction, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.create_transaction_menu -> {
                Log.i("menu", "click en menu guardar")
                createTransaction()
                return true
            }
            /*android.R.id.home -> {
                dismiss()
                return true
            }*/
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun createTransaction() {
        val amountTextInputEditText: TextInputEditText =
            view?.findViewById(R.id.editText_amount) as TextInputEditText
        val cardTextInputEditText: TextInputEditText =
            view?.findViewById(R.id.editText_card) as TextInputEditText

        var amount = amountTextInputEditText.text.toString()
        var card = cardTextInputEditText.text.toString()
        var validate: Boolean = true

        if (amount.isNullOrEmpty()) {
            amountTextInputEditText.error = "Digita el monto de la transacción"
            validate = false
        } else {
            validate = true
        }
        if (amount.isNullOrEmpty()) {
            cardTextInputEditText.error = "Digita el Número de tarjeta"
            validate = false
        } else {
            validate = true
        }

        if (validate) {
            viewModelTransaction.setFilterTransaction(
                AuthorizationRequest(
                    "001",
                    "000123",
                    "000ABC",
                    amount,
                    card
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
                        //dismiss()
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
    }


}