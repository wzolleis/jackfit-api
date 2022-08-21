package de.wz.jackfit.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    log.info("configure routing")
    install(StatusPages) {
        exception<AuthenticationException> { call, cause ->
            call.respond(HttpStatusCode.Unauthorized)
        }
        exception<AuthorizationException> { call, cause ->
            call.respond(HttpStatusCode.Forbidden)
        }

    }

    routing {
        get("/api/hello") {
            call.respondText("Hello World!")
        }
    }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
