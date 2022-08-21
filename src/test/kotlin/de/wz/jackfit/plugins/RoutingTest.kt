package de.wz.jackfit.plugins

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*

class RoutingTest : StringSpec({
    "say hello should return the famous Hello World" {
        testApplication {
            client.get("/api/hello").apply {
                status shouldBe HttpStatusCode.OK
                bodyAsText() shouldBe "Hello World!"
            }
        }
    }
})