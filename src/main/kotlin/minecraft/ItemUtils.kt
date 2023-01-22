package minecraft

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import java.util.*

fun ItemStack.repair() : Boolean {
    if (!this.isDamaged()) return false
    val meta = this.itemMeta as Damageable
    meta.damage = 0
    this.itemMeta = meta
    return true
}

fun Player.repairAllItems() : Int {
    var repairedItems = 0
    this.inventory.contents.mapNotNull{ it }.forEach{ if (it.repair()) repairedItems++ }
    return repairedItems
}

fun ItemStack.isDamaged() : Boolean {
    if (this.itemMeta !is Damageable) return false
    return ((this.itemMeta as Damageable).damage != 0)
}

fun Material.prettyMaterialName(): String {
    val fixed: String = this.toString().replace("_", " ")
    return fixed.substring(0, 1).uppercase(Locale.getDefault()) + fixed.substring(1).lowercase(Locale.getDefault())
}

fun ItemStack.prettyMaterialName() = this.type.prettyMaterialName()