package de.wz.jackfit.infrastructure.databse

import org.jetbrains.exposed.dao.id.UUIDTable

object Exercises : UUIDTable(name = "T_EXERCISE") {
    val name = varchar("name", 200)
    val type = varchar("type", 200)
}

object Users : UUIDTable(name = "T_USER") {
    val name = varchar("name", 200)

}