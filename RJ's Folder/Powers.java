 if (power1Pressed) {
            // This goes in your main mod class

// Add this to your imports
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

// Add this field to your class
private static final int PROJECTILE_DAMAGE = 6;

// Add this method to your class
public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    ItemStack itemstack = playerIn.getHeldItem(handIn);

    if (!worldIn.isRemote) {
        // Spawn the projectile
        ProjectileEntity projectile = new ProjectileEntity(worldIn, playerIn);
        projectile.setDamage(PROJECTILE_DAMAGE);
        projectile.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.addEntity(projectile);
    }

    // Decrement the stack size
    itemstack.shrink(1);

    return ActionResult.resultSuccess(itemstack);
}

// This goes in a separate class file for your projectile entity
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class ProjectileEntity extends ProjectileItemEntity {

    public ProjectileEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ProjectileEntity(World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    public ProjectileEntity(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected Item getDefaultItem() {
        // Replace this with the item you want to respawn in the player's inventory
        return Items.SNOWBALL;
    }

    @Override
    protected void onImpact(EntityRayTraceResult result) {
        if (result.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)result.getEntity();
            livingEntity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), PROJECTILE_DAMAGE);
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }
}

        }
        if (power2Pressed) {
            // Power 2 is being pressed
        }
        if (power3Pressed) {
            // Power 3 is being pressed
        }
        if (power4Pressed) {
            // Power 4 is being pressed
        }
        if (power5Pressed) {
            // Power 5 is being pressed
        }
        if (power6Pressed) {
            // Power 6 is being pressed
        }
        if (power7Pressed) {
            // Power 7 is being pressed
        }
        if (power8Pressed) {
            // Power 8 is being pressed
        }
        if (power9Pressed) {
            // Power 9 is being pressed
        }
        if (power10Pressed) {
            // Power 10 is being pressed
        }