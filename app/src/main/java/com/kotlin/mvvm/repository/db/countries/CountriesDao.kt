package com.kotlin.mvvm.repository.db.countries

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.mvvm.repository.model.countries.Country

/**
 * Created by Waheed on 08,November,2019
 */

/**
 * Abstracts access to the countries database
 */
@Dao
interface CountriesDao {

    /**
     * Insert countries into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countries: List<Country>): List<Long>

    /**
     * Get all countries from database
     */
    @Query("SELECT * FROM countries_table")
    fun getCountries(): LiveData<List<Country>>

    /**
     * Delete all countries from database
     */
    @Query("DELETE FROM countries_table")
    abstract fun deleteAllCountries()
}