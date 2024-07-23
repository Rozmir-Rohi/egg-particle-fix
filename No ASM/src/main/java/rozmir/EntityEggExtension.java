package rozmir;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEggExtension extends EntityEgg
{
    private int attackTimer;
    
    public EntityEggExtension(final World world) {
        super(world);
    }
    
    public EntityEggExtension(World world, EntityLivingBase thrower)
    {
        super(world, thrower);
    }
    
    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition)
    {
        if (movingObjectPosition.entityHit != null)
        {
            movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
        {
            byte amountOfBabyChickenToSpawn = 1;

            if (this.rand.nextInt(32) == 0)
            {
                amountOfBabyChickenToSpawn = 4;
            }

            for (int index = 0; index < amountOfBabyChickenToSpawn; ++index)
            {
                EntityChicken entityChicken = new EntityChicken(this.worldObj);
                entityChicken.setGrowingAge(-24000);
                entityChicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entityChicken);
            }
        }

        for (int index = 0; index < 8; ++index)
        {
            this.worldObj.spawnParticle("iconcrack_344", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }	
}