package com.peterfam.markit.feature_note.data.data_source

import androidx.room.Database
import com.peterfam.markit.feature_note.domain.model.Mark

@Database(
    entities = [Mark::class],
    version = 1
    )
abstract class MarkDatabase {
    abstract val markDao: MarkDao
}