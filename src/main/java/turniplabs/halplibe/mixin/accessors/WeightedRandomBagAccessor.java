package turniplabs.halplibe.mixin.accessors;

import net.minecraft.core.WeightedRandomBag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(value = WeightedRandomBag.class, remap = false)
public interface WeightedRandomBagAccessor {
    @Accessor("entries")
    List<WeightedRandomBag.Entry> getRawEntries();
    @Accessor
    double getAccumulatedWeight();
    @Accessor("accumulatedWeight")
    void setAccumulatedWeight(double weight);
}
