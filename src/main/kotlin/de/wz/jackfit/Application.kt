import de.wz.jackfit.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    configureDatabase()
    configureSecurity()
    configureRouting()
    configureSerialization()
    configureMonitoring()
}