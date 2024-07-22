package rozmir.egg_particle_fix;


import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.launchwrapper.IClassTransformer;
import scala.tools.asm.ClassReader;
import scala.tools.asm.ClassWriter;
import scala.tools.asm.tree.AbstractInsnNode;
import scala.tools.asm.tree.ClassNode;
import scala.tools.asm.tree.MethodNode;

public class EggParticleFixClassTransformer implements IClassTransformer {
	public byte[] transform(String className, String transformedName, byte[] classBeingTransformed) 
	{
	   if (
			   className.equals("zl") //obfuscated name for EntityEgg class
			   || className.equals("net.minecraft.entity.projectile.EntityEgg") //unobfuscated name
		  )
	   {
		   System.out.println("[Egg Particle Fix]: Currently inside the transformer and about to patch: " + className);
		   classBeingTransformed = patchClassInJar(className, classBeingTransformed, className, EggParticleFixFMLLoadingPlugin.location);
	   }
	   return classBeingTransformed;
	}

	public byte[] patchClassInJar(String name, byte[] bytes, String obfuscatedName, File location)
	{
		try 
		{
			ZipFile zipFile = new ZipFile(location);
		    ZipEntry entry = zipFile.getEntry(name.replace('.', '/') + ".class");
		    if (entry == null) 
		    {
		    	System.out.println("[Egg Particle Fix]: " + name + " not found in " + location.getName());
		    }
		    else
		    {
		    	InputStream zipFileInputStream = zipFile.getInputStream(entry);
		        bytes = new byte[(int)entry.getSize()];
		        zipFileInputStream.read(bytes);
		        zipFileInputStream.close();
		        System.out.println("[Egg Particle Fix]: Class " + name + " has been patched!");
		     }
		
		     zipFile.close();
		     return bytes;
		}
		catch (Exception var8) 
		{
			throw new RuntimeException("[Egg Particle Fix]: Error overriding " + name + " from " + location.getName(), var8);
		}
	}
}
