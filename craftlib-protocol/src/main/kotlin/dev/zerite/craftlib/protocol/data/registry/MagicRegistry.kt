package dev.zerite.craftlib.protocol.data.registry

import dev.zerite.craftlib.protocol.data.registry.impl.*
import dev.zerite.craftlib.protocol.version.ProtocolVersion

/**
 * Registry for storing the data about all the protocol-related
 * enums and their mappings.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
object MagicRegistry {

    /**
     * Mappings for the difficulty values.
     */
    val difficulty = create<MagicDifficulty> {
        ProtocolVersion.MC1_7_2 {
            MagicDifficulty.PEACEFUL to 0
            MagicDifficulty.EASY to 1
            MagicDifficulty.NORMAL to 2
            MagicDifficulty.HARD to 3
        }
        ProtocolVersion.MC1_7_6 {
            MagicDifficulty.PEACEFUL to "example"
            MagicDifficulty.EASY to "easy"
            MagicDifficulty.NORMAL to "normal"
            MagicDifficulty.HARD to "hard"
        }
    }

    /**
     * Mappings for the dimension values.
     */
    val dimension = create<MagicDimension> {
        ProtocolVersion.MC1_7_2 {
            MagicDimension.NETHER to -1
            MagicDimension.OVERWORLD to 0
            MagicDimension.END to 1
        }
    }

    /**
     * Mappings for the gamemode values.
     */
    val gamemode = create<MagicGamemode> {
        ProtocolVersion.MC1_7_2 {
            MagicGamemode.SURVIVAL to 0
            MagicGamemode.CREATIVE to 1
            MagicGamemode.ADVENTURE to 2
        }
    }

    /**
     * Stores the reason for the game state update packet.
     */
    val gameStateReason = create<MagicGameStateReason> {
        ProtocolVersion.MC1_7_2 {
            MagicGameStateReason.INVALID_BED to 0
            MagicGameStateReason.BEGIN_RAINING to 1
            MagicGameStateReason.END_RAINING to 2
            MagicGameStateReason.CHANGE_GAME_MODE to 3
            MagicGameStateReason.ENTER_CREDITS to 4
            MagicGameStateReason.DEMO_MESSAGES to 5
            MagicGameStateReason.BOW_HIT_SOUND to 6
            MagicGameStateReason.FADE_VALUE to 7
            MagicGameStateReason.FADE_TIME to 8
        }
    }

    /**
     * Stores the possible actions for the update block entity packet.
     */
    val blockEntityUpdateAction = create<MagicBlockEntityUpdateAction> {
        ProtocolVersion.MC1_7_2 {
            MagicBlockEntityUpdateAction.SET_SPAWNER_MOB to 1
        }
    }

    /**
     * Stores the possible animations for the animation packet.
     */
    val animation = create<MagicAnimation> {
        ProtocolVersion.MC1_7_2 {
            MagicAnimation.SWING_ARM to 0
            MagicAnimation.DAMAGE_ANIMATION to 1
            MagicAnimation.LEAVE_BED to 2
            MagicAnimation.EAT_FOOD to 3
            MagicAnimation.CRITICAL_EFFECT to 4
            MagicAnimation.MAGIC_CRITICAL_EFFECT to 5
            MagicAnimation.CROUCH to 104
            MagicAnimation.UNCROUCH to 105
        }
    }

    /**
     * Stores the possible objects for the spawn object packet.
     */
    val objects = create<MagicObject> {
        ProtocolVersion.MC1_7_2 {
            MagicObject.BOAT to 1
            MagicObject.ITEM_STACK to 2
            MagicObject.MINECART to 10
            MagicObject.MINECART_STORAGE to 11
            MagicObject.MINECART_POWERED to 12
            MagicObject.ACTIVATED_TNT to 50
            MagicObject.ENDER_CRYSTAL to 51
            MagicObject.ARROW to 60
            MagicObject.SNOWBALL to 61
            MagicObject.EGG to 62
            MagicObject.FIREBALL to 63
            MagicObject.FIRE_CHARGE to 64
            MagicObject.THROWN_ENDER_PEARL to 65
            MagicObject.WITHER_SKULL to 66
            MagicObject.FALLING_OBJECT to 70
            MagicObject.ITEM_FRAME to 71
            MagicObject.EYE_OF_ENDER to 72
            MagicObject.THROWN_POTION to 73
            MagicObject.FALLING_DRAGON_EGG to 74
            MagicObject.THROWN_EXP_BOTTLE to 75
            MagicObject.FISHING_FLOAT to 90
        }
    }

    /**
     * Stores the valid entity status values for the entity status packet.
     */
    val entityStatus = create<MagicEntityStatus> {
        ProtocolVersion.MC1_7_2 {
            MagicEntityStatus.ENTITY_HURT to 2
            MagicEntityStatus.ENTITY_DEAD to 3
            MagicEntityStatus.WOLF_TAMING to 6
            MagicEntityStatus.WOLF_TAMED to 7
            MagicEntityStatus.WOLF_SHAKING_WATER to 8
            MagicEntityStatus.EATING_ACCEPTED to 9
            MagicEntityStatus.SHEEP_EATING_GRASS to 10
            MagicEntityStatus.IRON_GOLEM_ROSE to 11
            MagicEntityStatus.VILLAGER_HEARTS to 12
            MagicEntityStatus.VILLAGER_ANGRY to 13
            MagicEntityStatus.VILLAGER_HAPPY to 14
            MagicEntityStatus.WITCH_MAGIC to 15
            MagicEntityStatus.CONVERT_ZOMBIE_VILLAGER to 16
            MagicEntityStatus.FIREWORK_EXPLODE to 17
        }
    }

    /**
     * Stores the values for a potion effect.
     */
    val potionEffect = create<MagicPotionEffect> {
        ProtocolVersion.MC1_7_2 {
            MagicPotionEffect.SPEED to 1
            MagicPotionEffect.SLOWNESS to 2
            MagicPotionEffect.HASTE to 3
            MagicPotionEffect.MINING_FATIGUE to 4
            MagicPotionEffect.STRENGTH to 5
            MagicPotionEffect.INSTANT_HEALTH to 6
            MagicPotionEffect.INSTANT_DAMAGE to 7
            MagicPotionEffect.JUMP_BOOST to 8
            MagicPotionEffect.NAUSEA to 9
            MagicPotionEffect.REGENERATION to 10
            MagicPotionEffect.RESISTANCE to 11
            MagicPotionEffect.FIRE_RESISTANCE to 12
            MagicPotionEffect.WATER_BREATHING to 13
            MagicPotionEffect.INVISIBILITY to 14
            MagicPotionEffect.BLINDNESS to 15
            MagicPotionEffect.NIGHT_VISION to 16
            MagicPotionEffect.HUNGER to 17
            MagicPotionEffect.WEAKNESS to 18
            MagicPotionEffect.POISON to 19
            MagicPotionEffect.WITHER to 20
            MagicPotionEffect.HEALTH_BOOST to 21
            MagicPotionEffect.ABSORPTION to 22
            MagicPotionEffect.SATURATION to 23
        }
    }

    /**
     * Creates a new Minecraft enum and provides a builder function
     * to initialize it.
     *
     * @param  build         The builder function to initialize these mappings.
     * @author Koding
     * @since  0.1.0-SNAPSHOT
     */
    private fun <T : RegistryEntry> create(build: MinecraftRegistry<T>.() -> Unit) =
        MinecraftRegistry<T>().apply(build).apply { rebuild() }

}

/**
 * Represents a single registry entry.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
open class RegistryEntry(@Suppress("UNUSED") open val name: String) {
    override fun toString() = name
}

/**
 * Base for all unknown registry entries to inherit.
 *
 * @author Koding
 * @since  0.1.0-SNAPSHOT
 */
data class UnknownRegistryEntry<T : Any>(@Suppress("UNUSED") val raw: T) :
    RegistryEntry("UNKNOWN")