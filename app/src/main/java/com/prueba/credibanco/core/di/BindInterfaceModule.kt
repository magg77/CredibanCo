package com.prueba.credibanco.core.di

import com.prueba.credibanco.data.provider.local.serviceLocal.LocalDataSourceImpl
import com.prueba.credibanco.data.provider.local.serviceLocal.LocalDataSourceInterface
import com.prueba.credibanco.data.provider.remote.server.DataSourceRemoteImpl
import com.prueba.credibanco.data.provider.remote.server.DataSourceRemoteInterface
import com.prueba.credibanco.data.repository.RepoImpl
import com.prueba.credibanco.data.repository.RepoInterface
import com.prueba.credibanco.domain.TransactionUseCase
import com.prueba.credibanco.domain.TransactionUseCaseContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


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

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindInterfaceModule {

    @Binds
    abstract fun bindTransactionUseCase(transactionUseCase: TransactionUseCase)
            : TransactionUseCaseContract

    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl)
            : RepoInterface

    @Binds
    abstract fun bindRemoteDataSource(dataSourceRemoteImpl: DataSourceRemoteImpl)
            : DataSourceRemoteInterface

    @Binds
    abstract fun bindLocalDataSource(localDataSourceInterface: LocalDataSourceImpl): LocalDataSourceInterface

}