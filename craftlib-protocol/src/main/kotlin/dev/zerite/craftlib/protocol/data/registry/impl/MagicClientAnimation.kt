package dev.zerite.craftlib.protocol.data.registry.impl

import dev.zerite.craftlib.protocol.data.registry.IMinecraftRegistry
import dev.zerite.craftlib.protocol.data.registry.LazyRegistryDelegate
import dev.zerite.craftlib.protocol.data.registry.MagicRegistry
import dev.zerite.craftlib.protocol.data.registry.RegistryEntry

/**
 * Stores values for the server animation packet.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
open class MagicClientAnimation(name: String) : RegistryEntry(name) {

    companion object :
        IMinecraftRegistry<MagicClientAnimation> by LazyRegistryDelegate({ MagicRegistry.clientAnimation }) {
        val NO_ANIMATION = MagicClientAnimation("No Animation")
        val SWING_ARM = MagicClientAnimation("Swing Arm")
        val DAMAGE_ANIMATION = MagicClientAnimation("Damage Animation")
        val LEAVE_BED = MagicClientAnimation("Leave Bed")
        val EAT_FOOD = MagicClientAnimation("Eat Food")
        val CRITICAL_EFFECT = MagicClientAnimation("Critical Effect")
        val MAGIC_CRITICAL_EFFECT = MagicClientAnimation("Magic Critical Effect")
        val CROUCH = MagicClientAnimation("Crouch")
        val UNCROUCH = MagicClientAnimation("Un-crouch")
    }

}
