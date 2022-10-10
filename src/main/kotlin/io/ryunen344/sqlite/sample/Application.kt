package io.ryunen344.sqlite.sample

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ryunen344.sqlite.sample.plugins.configureRouting
import io.ryunen344.sqlite.sample.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
