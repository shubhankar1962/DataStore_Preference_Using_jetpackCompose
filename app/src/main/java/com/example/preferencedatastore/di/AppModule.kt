package com.example.preferencedatastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.preferencedatastore.pref.UserPref
import com.example.preferencedatastore.pref.UserPrefImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    //for creating a datastore
//    @Singleton
    @Provides
    fun provideDatastore(@ApplicationContext context: Context):DataStore<Preferences>{
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(            //with the help of this code we can catch the corruption exception and produce the data
                produceNewData = { emptyPreferences() }
            ),
            produceFile = {context.preferencesDataStoreFile("user_data")}
        )
    }

    //
    @Provides
    fun provideUserPref(dataStore: DataStore<Preferences>): UserPref = UserPrefImpl(dataStore)
}