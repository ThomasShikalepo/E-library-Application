package com.example.e_library.data.di

import com.example.e_library.data.RepoImplementation.AllBookRepoImplementation
import com.example.e_library.domain.repo.AllBookRepo
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent :: class)
object HiltModel {
    @Provides
    @Singleton
    fun provideRealtimeDatabase() : FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage {

        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideAllBookRepo(firebaseDatabase: FirebaseDatabase) : AllBookRepo{

        return AllBookRepoImplementation(firebaseDatabase)
    }
}