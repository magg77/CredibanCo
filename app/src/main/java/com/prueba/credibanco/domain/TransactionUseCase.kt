package com.prueba.credibanco.domain

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import com.prueba.credibanco.data.repository.RepoInterface
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

class TransactionUseCase(private val repo: RepoInterface) :
    TransactionUseCaseContract {


    override suspend fun invoke(
        auth: String,
        authorizationRequest: AuthorizationRequest
    ): Resource<List<AuthorizationResponse>> {
        return repo.authorization(auth, authorizationRequest)
    }


}