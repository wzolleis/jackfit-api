package de.wz.jackfit.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import de.wz.jackfit.infrastructure.databse.Exercises
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.module() {
    configureDatabase()
    createOrUpdateTables()
}

fun Application.configureDatabase() {
    val dbUrl = environment.config.property("ktor.jackfit.application.database.dbUrl")
     val dbDriverClassName = environment.config.property("ktor.jackfit.application.database.dbDriverClassName")

    val config = HikariConfig().apply {
        jdbcUrl         =  dbUrl.getString()
        driverClassName = dbDriverClassName.getString()
        maximumPoolSize = 5
    }

    val dataSource = HikariDataSource(config)
    DbSettings.db = Database.connect(dataSource)
}

fun Application.createOrUpdateTables() {
    transaction {
        addLogger(StdOutSqlLogger)
        val tables = listOf(Exercises)
        SchemaUtils.create(*tables.toTypedArray())
        SchemaUtils.createMissingTablesAndColumns(*tables.toTypedArray())
    }
}

object DbSettings {
    var db: Database? = null
}
