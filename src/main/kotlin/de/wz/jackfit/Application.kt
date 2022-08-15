package de.wz.jackfit

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import de.wz.jackfit.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
