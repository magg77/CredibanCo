package com.prueba.credibanco.presentation

import android.util.Base64
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.local.entity.AnnulmentEntity
import com.prueba.credibanco.data.provider.local.entity.AuthorizationEntity
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import com.prueba.credibanco.domain.TransactionUseCaseContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

@HiltViewModel
class TransactionViewModel @Inject constructor(private val useCase: TransactionUseCaseContract) :
    ViewModel() {

    private val filterTransaction = MutableLiveData<AuthorizationRequest>()

    private val _response: MutableLiveData<Resource<AuthorizationResponse>> = MutableLiveData()
    val response: LiveData<Resource<AuthorizationResponse>> = _response



    fun setFilterTransaction(authorizationRequest: AuthorizationRequest) = viewModelScope.launch {
        _response.value = useCase.create_transaction("Basic MDAwMTIzMDAwQUJD", authorizationRequest)
    }

    fun setFilterTransaction2(authorizationRequest: AuthorizationRequest):  LiveData<Resource<AuthorizationResponse>> =
        liveData(viewModelScope.coroutineContext + Dispatchers.Main) {

            //for apis >= 26
            /*val commerceCode: String = Base64.getEncoder().encodeToString(authorizationRequest.commerceCode.toByteArray())
            val terminalCode = Base64.getEncoder().encodeToString(authorizationRequest.terminalCode.toByteArray())*/

            val binaryComerce: ByteArray = authorizationRequest.commerceCode.toByteArray(StandardCharsets.UTF_8)
            val commerceCode = Base64.encode(binaryComerce, Base64.NO_WRAP)

            val binaryTerminal: ByteArray = authorizationRequest.terminalCode.toByteArray(StandardCharsets.UTF_8)
            val terminalCode = Base64.encode(binaryTerminal, Base64.NO_WRAP)

            /*Log.i("base", "${commerceCode.toString()}")
            Log.i("base", "${terminalCode.toString()}")*/

            //val output_decode = String(decode, StandardCharsets.UTF_8)

            emit(Resource.Loading())
            try {
                //useCase.invoke("${commerceCode}${terminalCode}", AuthorizationRequest())
                emit(useCase.create_transaction("Basic MDAwMTIzMDAwQUJD", authorizationRequest))
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
            }
    }


    /*fun getAuthorizationAll() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(useCase.getAuthorizationAll())
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }*/

    fun insertAthorization(authorizationEntity: AuthorizationEntity) {
        viewModelScope.launch {
            useCase.insertAthorization(authorizationEntity)
        }
    }

    fun annulmentTransaction(annulmentEntity: AnnulmentEntity) {
        viewModelScope.launch {
            useCase.annulmentTransaction(annulmentEntity)
        }
    }





}