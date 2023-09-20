package com.prueba.credibanco.ui.transaction

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.prueba.credibanco.R
import com.prueba.credibanco.databinding.FragmentTransactionBinding


class CreateTransactionFragment : DialogFragment() {

    /*private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!*/


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        isCancelable = false
        return inflater.inflate(R.layout.fragment_create_transaction, container, false)

        /*_binding = FragmentTransactionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root*/
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

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


        val button : Button = view.findViewById(R.id.button) as Button
        button.setOnClickListener {
            findNavController().navigateUp()
            dismiss()
        }

        (dialog as androidx.activity.ComponentDialog)
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
                dismiss()
            }

        dialog?.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                requireActivity().onBackPressed()
                return@setOnKeyListener true
            }
            false
        }

    }

    override fun onResume() {
        super.onResume()
    }


}