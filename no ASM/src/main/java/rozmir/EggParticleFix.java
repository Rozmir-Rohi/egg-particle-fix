package rozmir;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "eggparticlefix", name = "Egg Particle Fix No ASM", version = "1.0")
public class EggParticleFix
{
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        int ModEntityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerModEntity((Class)EntityEggExtension.class, "Egg", ModEntityID++, (Object)this, 50, 2, true);
        MinecraftForge.EVENT_BUS.register((Object)new EventReplaceEntityEgg());
    }
}