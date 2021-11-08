package com.peterfam.markit.di

import androidx.room.Room
import com.peterfam.markit.MarkItApp
import com.peterfam.markit.feature_note.data.data_source.MarkItDatabase
import com.peterfam.markit.feature_note.data.repository.MarkItRepositoryImpl
import com.peterfam.markit.feature_note.domain.repository.MarkItRepository
import com.peterfam.markit.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarkItDatabase(app: MarkItApp): MarkItDatabase{
        return Room.databaseBuilder(
            app,
            MarkItDatabase::class.java,
            MarkItDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMarkItRepository(db: MarkItDatabase): MarkItRepository{
        return MarkItRepositoryImpl(db.markItDao)
    }

    @Provides
    @Singleton
    fun provideMarkItUseCases(repository: MarkItRepository): MarkItUseCases{
        return MarkItUseCases(
            getMarksUseCase = GetMarksUseCase(repository),
            addMarkUseCase = AddMarkUseCase(repository),
            deleteMarkUseCase = DeleteMarkUseCase(repository),
            getMarkByIdUseCase = GetMarkByIdUseCase(repository)
        )
    }
}