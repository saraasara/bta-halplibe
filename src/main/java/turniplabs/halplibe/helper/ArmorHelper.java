package turniplabs.halplibe.helper;

import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.util.helper.DamageType;
import turniplabs.halplibe.util.ArmorMaterialMixinInterface;

abstract public class ArmorHelper {

    /**
     * Damage parameters can be more than 100%. Armor durability will be a bit different from in-game.
     * Put armor textures in <i>armor/</i>
     * @param name        name of the armor used for its texture files
     * @param durability  durability of your armor
     * @param combat      combat damage reduction in percent
     * @param blast       blast damage reduction in percent
     * @param fire        fire damage reduction in percent
     * @param fall        fall damage reduction in percent
     */
    @Deprecated
    public static ArmorMaterial createArmorMaterial(String name, int durability, float combat, float blast, float fire, float fall) {
        ArmorMaterial armorMaterial = new ArmorMaterial(name, ArmorMaterial.getArmorMaterials().size()-1, durability)
        .withProtectionPercentage(DamageType.COMBAT, combat)
        .withProtectionPercentage(DamageType.BLAST, blast)
        .withProtectionPercentage(DamageType.FIRE, fire)
        .withProtectionPercentage(DamageType.FALL, fall);

        return ArmorMaterial.register(armorMaterial);
    }

    /**
     * Damage parameters can be more than 100%. Armor durability will be a bit different from in-game.
     * @param name        name of the armor used for its texture files
     * @param durability  durability of your armor
     * @param combat      combat damage reduction in percent
     * @param blast       blast damage reduction in percent
     * @param fire        fire damage reduction in percent
     * @param fall        fall damage reduction in percent
     */
    @SuppressWarnings("unused") // API function
    public static ArmorMaterial createArmorMaterial(String modId, String name, int durability, float combat, float blast, float fire, float fall) {
        ArmorMaterial armorMaterial = new ArmorMaterial(name, ArmorMaterial.getArmorMaterials().size()-1, durability)
                .withProtectionPercentage(DamageType.COMBAT, combat)
                .withProtectionPercentage(DamageType.BLAST, blast)
                .withProtectionPercentage(DamageType.FIRE, fire)
                .withProtectionPercentage(DamageType.FALL, fall);

        ((ArmorMaterialMixinInterface) armorMaterial).halplibe$SetModId(modId);

        return ArmorMaterial.register(armorMaterial);
    }
}
