import de.wz.jackfit.plugins.configureMonitoring
import de.wz.jackfit.plugins.configureRouting
import de.wz.jackfit.plugins.configureSecurity
import de.wz.jackfit.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    configureSecurity()
    configureRouting()
    configureSerialization()
    configureMonitoring()
}