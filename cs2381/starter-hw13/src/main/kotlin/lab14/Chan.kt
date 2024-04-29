package lab14

import org.phoenixframework.Channel
import org.phoenixframework.Socket

class Chan(val url: String, val name: String, val game: String) {
    val socket: Socket
    val channel: Channel

    init {
        this.socket = Socket(url, mapOf())
        socket.connect()

        this.channel = socket.channel("game:" + game, mapOf("name" to name))
        channel.join()
            .receive("ok") { resp -> App.onJoin(resp.payload) }
            .receive("error") { msg -> System.out.println("errror: " + msg) }

        channel.on("view") { msg -> App.onView(msg.payload) }
    }

    fun guess(ch: String) {
        channel.push("guess", mapOf("ch" to ch));
    }
}
