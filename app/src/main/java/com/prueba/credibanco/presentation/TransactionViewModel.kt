package com.prueba.credibanco.presentation

import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import com.prueba.credibanco.domain.TransactionUseCaseContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.nio.charset.StandardCharsets
import javax.inject.Inject


/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: magg77
 * @DATE: 14,septiembre,2023
 * @COMPAN:
 * @EMAIL: escenariopaloma@gmail.com
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su propietario y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 *
 */

class TransactionViewModel(private val useCase: TransactionUseCaseContract) :
    ViewModel() {

    private val filterTransaction = MutableLiveData<AuthorizationRequest>()

    fun setFilterTransaction(authorizationRequest: AuthorizationRequest):  LiveData<Resource<List<AuthorizationResponse>>> = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {

            //val commerceCode: String = Base64.getEncoder().encodeToString(authorizationRequest.commerceCode.toByteArray())  //authorizationRequest.terminalCode.toByteArray(StandardCharsets.UTF_8)
            //val terminalCode = Base64.getEncoder().encodeToString(authorizationRequest.terminalCode.toByteArray())

            /*val binaryComerce: ByteArray = authorizationRequest.commerceCode.toByteArray(StandardCharsets.UTF_8)
            val commerceCode = Base64.decode(binaryComerce, Base64.NO_WRAP)

            val binaryTerminal: ByteArray = authorizationRequest.terminalCode.toByteArray(StandardCharsets.UTF_8)
            val terminalCode = Base64.decode(binaryTerminal, Base64.NO_WRAP)*/

            //val output_decode = String(decode, StandardCharsets.UTF_8)

            emit(Resource.Loading())
            try {
                emit(
                    //useCase.invoke("${commerceCode}${terminalCode}", AuthorizationRequest())
                    useCase.invoke("Basic MDAwMTIzMDAwQUJD", authorizationRequest)
                )
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }





}