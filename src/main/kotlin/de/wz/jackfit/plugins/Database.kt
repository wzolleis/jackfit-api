package de.wz.jackfit.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    val dbUrl = environment.config.property("ktor.jackfit.application.database.dbUrl")
    val dbUser = environment.config.property("ktor.jackfit.application.database.dbUser")
    val dbPassword = environment.config.property("ktor.jackfit.application.database.dbPassword")

    val config = HikariConfig().apply {
        jdbcUrl         =  dbUrl.getString()
        driverClassName = "org.mariadb.jdbc.Driver"
        username        = dbUser.getString()
        password        = dbPassword.getString()
        maximumPoolSize = 10
    }

    val dataSource = HikariDataSource(config)
    DbSettings.db = Database.connect(dataSource)
}

object DbSettings {
    var db: Database? = null
}
