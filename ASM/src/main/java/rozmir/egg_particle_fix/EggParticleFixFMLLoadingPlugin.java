package rozmir.egg_particle_fix;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import net.minecraft.launchwrapper.Launch;


@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name("Egg Particle Fix FML Loading Plugin")
@IFMLLoadingPlugin.TransformerExclusions("rozmir.egg_particle_fix")

public class EggParticleFixFMLLoadingPlugin implements IFMLLoadingPlugin {
	public static File location;
	
    @Override
    public String[] getASMTransformerClass()
    {	
    	boolean isDevelopmentEnvironment = (boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
    	
    	if (!isDevelopmentEnvironment)
    	{
    		return new String[] { EggParticleFixClassTransformer.class.getName() };
    	}
    	
    	return null; // do not run transformer if in development environment
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }
   
   @Override
   public void injectData(Map<String, Object> data)
   {
      location = (File)data.get("coremodLocation");
   }

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}

}
