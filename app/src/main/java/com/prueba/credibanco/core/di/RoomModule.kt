package com.prueba.credibanco.core.di

import android.content.Context
import androidx.room.Room
import com.prueba.credibanco.core.valueObject.AppDatabaseRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: magg77
 * @DATE: 16,septiembre,2023
 * @COMPAN:
 * @EMAIL: escenariopaloma@gmail.com
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su propietario y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 *
 */

@Module
@InstallIn(SingletonComponent::class) //scope = SingletonComponent -> Application
object RoomModule {

    private const val BD_NAME_ROOM = "CredibanCoRoomDatabase"


    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) = synchronized(this) {
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabaseRoom::class.java,
            BD_NAME_ROOM,
        )
    }

}