package me.bush.instantdeepslate;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

public class BlockTweak {
    private static final String EXPLOSION = "aH";

    private static final String PROPERTIES = "aO";
    private static final String EXPLOSION_PROP = "f";
    private static final String DESTROYSPEED_PROP = "g";

    private static final String BLOCKSTATE = "d";
    private static final String DESTROYSPEED_BS = "k";

    private final Block block;
    private float[] defaultBehavior;
    private float[] targetBehavior;

    public BlockTweak(Block block, Block target) {
        try {
            this.defaultBehavior = this.getBlockProperties(block);
        } catch (Exception exception) {
            InstantDeepslate.logger.error("Could not get block properties for " + block.getDescriptionId(), exception);
        }
        try {
            this.targetBehavior = this.getBlockProperties(target);
        } catch (Exception exception) {
            InstantDeepslate.logger.error("Could not get block properties for " + target.getDescriptionId(), exception);
        }
        this.block = block;
    }

    public void enable() {
        if (this.targetBehavior == null) return;
        try {
            this.setBlockProperties(this.block, this.targetBehavior);
        } catch (Exception exception) {
            InstantDeepslate.logger.error("Could not change block properties for " + this.block.getDescriptionId(), exception);
        }
    }

    public void disable() {
        if (this.defaultBehavior == null) return;
        try {
            this.setBlockProperties(this.block, this.defaultBehavior);
        } catch (Exception exception) {
            InstantDeepslate.logger.error("Could not revert block properties for " + this.block.getDescriptionId(), exception);
        }
    }

    private float[] getBlockProperties(Block block) throws Exception {
        Properties properties = (Properties) getObject(block, PROPERTIES);
        return new float[]{
                block.getExplosionResistance(),
                getFloat(properties, EXPLOSION_PROP),
                getFloat(properties, DESTROYSPEED_PROP),
                block.defaultBlockState().destroySpeed
        };
    }

    private void setBlockProperties(Block block, float[] targetProperties) throws Exception {
        setFloat(block, EXPLOSION, targetProperties[0]);
        Properties properties = (Properties) getObject(block, PROPERTIES);
        setFloat(properties, EXPLOSION_PROP, targetProperties[1]);
        setFloat(properties, DESTROYSPEED_PROP, targetProperties[2]);
        setFloat(getObject(block, BLOCKSTATE), DESTROYSPEED_BS, targetProperties[3]);
    }

    private static void setFloat(Object object, String name, float value) throws Exception {
        // Cannot use FieldUtils.writeField for some reason, it
        // gives us a warning about the field being final.
        for (Field field : FieldUtils.getAllFields(object.getClass())) {
            if (field.getName().equals(name)) {
                field.setAccessible(true);
                field.setFloat(object, value);
                return;
            }
        }
    }

    private static float getFloat(Object object, String name) throws Exception {
        return ((float) FieldUtils.readField(object, name, true));
    }

    private static Object getObject(Object object, String name) throws Exception {
        return FieldUtils.readField(object, name, true);
    }
}
