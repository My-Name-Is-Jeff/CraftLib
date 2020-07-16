package dev.zerite.craftlib.protocol.packet.play.server.world

import dev.zerite.craftlib.protocol.Packet
import dev.zerite.craftlib.protocol.PacketIO
import dev.zerite.craftlib.protocol.ProtocolBuffer
import dev.zerite.craftlib.protocol.connection.NettyConnection
import dev.zerite.craftlib.protocol.data.world.ChunkColumn
import dev.zerite.craftlib.protocol.data.world.ChunkMetadata
import dev.zerite.craftlib.protocol.util.ext.deflated
import dev.zerite.craftlib.protocol.util.ext.inflated
import dev.zerite.craftlib.protocol.version.ProtocolVersion

/**
 * Chunks are not unloaded by the client automatically. To unload chunks, send this
 * packet with ground-up continuous=true and no 16^3 chunks (eg. primary bit mask=0).
 *
 * The server does not send skylight information for nether-chunks, it's up to the client
 * to know if the player is currently in the nether. You can also infer this information from
 * the primary bitmask and the amount of uncompressed bytes sent.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
data class ServerPlayChunkDataPacket(
    var column: ChunkColumn,
    var groundUp: Boolean
) : Packet() {
    companion object : PacketIO<ServerPlayChunkDataPacket> {
        override fun read(
            buffer: ProtocolBuffer,
            version: ProtocolVersion,
            connection: NettyConnection
        ): ServerPlayChunkDataPacket {
            val metadata = ChunkMetadata(
                buffer.readInt(),
                buffer.readInt(),
                buffer.readBoolean(),
                buffer.readShort().toInt(),
                buffer.readShort().toInt()
            )

            return ServerPlayChunkDataPacket(
                buffer.readByteArray { readInt() }.inflated(196864)
                    .let { ChunkColumn.read(it, metadata, hasSkyLight = true) },
                metadata.biomes
            )
        }

        override fun write(
            buffer: ProtocolBuffer,
            version: ProtocolVersion,
            packet: ServerPlayChunkDataPacket,
            connection: NettyConnection
        ) {
            val (primaryBitmask, addBitmask, bytes) = ChunkColumn.write(packet.column, writeBiomes = packet.groundUp)
            buffer.writeInt(packet.column.x)
            buffer.writeInt(packet.column.z)
            buffer.writeBoolean(packet.groundUp)
            buffer.writeShort(primaryBitmask)
            buffer.writeShort(addBitmask)
            buffer.writeByteArray(bytes.deflated()) { writeInt(it) }
        }
    }
}
