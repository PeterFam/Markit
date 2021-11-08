package com.peterfam.markit.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.peterfam.markit.feature_note.domain.model.Mark

@Database(
    entities = [Mark::class],
    version = 1
    )
abstract class MarkItDatabase : RoomDatabase(){
    abstract val markItDao: MarkItDao

    companion object {
        const val DATABASE_NAME = "markit_database"
    }
}