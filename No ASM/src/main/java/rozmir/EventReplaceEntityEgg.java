package rozmir;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EventReplaceEntityEgg
{
    @SubscribeEvent
    public void OnEntityJoinWorld(EntityJoinWorldEvent event) 
	{
        if (!event.entity.worldObj.isRemote && event.entity.getClass() == EntityEgg.class)
		{
        	EntityEggExtension egg = new EntityEggExtension(event.entity.worldObj);
        	
        	if (((EntityThrowable) event.entity).getThrower() instanceof EntityLivingBase) //if there is a thrower add the thrower to the projectile entity data
        	{
        		event.entity.worldObj.spawnEntityInWorld(new EntityEggExtension(event.entity.worldObj, ((EntityThrowable) event.entity).getThrower()));
        	}
        	else
        	{   //manually set motion when not thrown by the player
        		egg.setThrowableHeading(event.entity.motionX, event.entity.motionY, event.entity.motionZ, 1.5F, 1.0F);
        		egg.copyLocationAndAnglesFrom((Entity)event.entity);
            	egg.worldObj.spawnEntityInWorld((Entity)egg);
        	}
        	
            event.entity.posY = -500; //send the old egg to the void. Couldn't use setDead here instead because it would print a "Fetching addPacket for removed entity" error to the log
        }
    }
}