package cat.itb.m78.exercices.sqldelight

import app.cash.sqldelight.db.SqlDriver
import cat.itb.m78.exercices.db.Database

expect fun createDriver(): SqlDriver

fun createDatabase() : Database {
    val driver = createDriver()
    Database.Schema.migrateIfNeeded(driver)
    return Database(driver)
}

val database by lazy { createDatabase() }