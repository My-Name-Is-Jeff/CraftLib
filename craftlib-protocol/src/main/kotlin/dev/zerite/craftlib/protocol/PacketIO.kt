package dev.zerite.craftlib.protocol

import com.google.gson.reflect.TypeToken
import dev.zerite.craftlib.protocol.connection.NettyConnection
import dev.zerite.craftlib.protocol.version.ProtocolVersion

/**
 * Handles IO operations for reading and writing packets from
 * and to packet ByteBuffers.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
@Suppress("UNUSED")
interface PacketIO<T : Packet> {

    /**
     * Retrieves the class for the packet generic.
     */
    val type: Class<in T>
        get() = (object : TypeToken<T>() {}).rawType

    /**
     * Reads a packet from the provided protocol buffer into an object.
     *
     * @param  buffer     The buffer which we are reading the packet from.
     * @param  version    The version of the connection.
     * @param  connection Reference to the connection which we are reading from.
     * @return The parsed packet object.
     *
     * @author Koding
     * @since  0.1.0-SNAPSHOT
     */
    fun read(buffer: ProtocolBuffer, version: ProtocolVersion, connection: NettyConnection): T

    /**
     * Writes a packet object into the raw buffer given the protocol version.
     *
     * @param  buffer     The buffer which we will write the packet to.
     * @param  version    The protocol version we should write for.
     * @param  packet     The packet we are writing to the buffer.
     * @param  connection Reference to the connection which we are writing to.
     *
     * @author Koding
     * @since  0.1.0-SNAPSHOT
     */
    fun write(buffer: ProtocolBuffer, version: ProtocolVersion, packet: T, connection: NettyConnection)

}

/**
 * Base class for all packets to inherit which includes a reference
 * to the connection this packet was read in.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
open class Packet