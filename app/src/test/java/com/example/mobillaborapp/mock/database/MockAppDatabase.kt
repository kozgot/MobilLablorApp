package com.example.mobillaborapp.mock.database

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.mobillaborapp.repository.database.AppDatabase
import com.example.mobillaborapp.repository.database.BreedDAO
import com.example.mobillaborapp.repository.database.ImageDAO

class MockAppDatabase : AppDatabase() {
    override fun breedDao(): BreedDAO {
        return MockBreedDAO()
    }

    override fun imageDao(): ImageDAO {
        return MockImageDAO()
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}