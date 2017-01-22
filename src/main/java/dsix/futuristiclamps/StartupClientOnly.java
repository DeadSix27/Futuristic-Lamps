package dsix.futuristiclamps;

import dsix.futuristiclamps.block.BlockFlatLampVariants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly {

    public static void preInitClientOnly() {
        final int DEFAULT_ITEM_SUBTYPE = 0;


        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.BLACK.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:blockFlatLampblack",
                        "inventory")
        );

        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.RED.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:blockFlatLampred",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.GREEN.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:blockFlatLampgreen",
                        "inventory")
        );

        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.BROWN.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_brown",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.BLUE.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_blue",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.PURPLE.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_purple",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.CYAN.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_cyan",
                        "inventory")
        );
       /*ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.LIGHTGRAY.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_lightgray",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.GRAY.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_gray",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.PINK.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_pink",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.LIME.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_lime",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.YELLOW.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_yellow",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.LIGHTBLUE.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_lightblue",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.MAGENTA.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_magenta",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.ORANGE.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_orange",
                        "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockFlatLampVariants,
                BlockFlatLampVariants.EnumColour.WHITE.getMetadata(),
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_white",
                        "inventory")
        );*/




        ModelLoader.setCustomModelResourceLocation(StartupCommon.itemFlatLampTransparent, DEFAULT_ITEM_SUBTYPE,
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_transparent",
                        "inventory")
        );
        /*ModelLoader.setCustomModelResourceLocation(StartupCommon.itemFlatLampBlack, DEFAULT_ITEM_SUBTYPE,
                new ModelResourceLocation(
                        "futuristiclamps:block_flat_lamp_black",
                        "inventory")
        );*/
    }

    public static void initClientOnly() {
    }

    public static void postInitClientOnly() {
    }
}