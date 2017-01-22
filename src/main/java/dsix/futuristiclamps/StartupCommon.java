package dsix.futuristiclamps;


import dsix.futuristiclamps.block.BlockFlatLampVariants;
import dsix.futuristiclamps.block.BlockFlatLampBlack;
import dsix.futuristiclamps.block.BlockFlatLampTransparent;
import dsix.futuristiclamps.block.ItemBlockFlatLampVariants;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {

    public static BlockFlatLampVariants blockFlatLampVariants;
    public static ItemBlockFlatLampVariants itemBlockFlatLampVariants;

    public static BlockFlatLampTransparent blockFlatLampTransparent;
    public static ItemBlock itemFlatLampTransparent;

    /*public static BlockFlatLampBlack blockFlatLampBlack;
    public static ItemBlock itemFlatLampBlack;*/


    public static void preInitCommon() {

        blockFlatLampVariants = (BlockFlatLampVariants) (new BlockFlatLampVariants().setUnlocalizedName("blocks.block_flat_lamp"));
        blockFlatLampVariants.setRegistryName("blockFlatLamp");
        GameRegistry.register(blockFlatLampVariants);

        itemBlockFlatLampVariants = new ItemBlockFlatLampVariants(blockFlatLampVariants);
        itemBlockFlatLampVariants.setRegistryName(blockFlatLampVariants.getRegistryName());
        GameRegistry.register(itemBlockFlatLampVariants);



       /* blockFlatLampBlack = (BlockFlatLampBlack) (new BlockFlatLampBlack().setUnlocalizedName("blocks.block_flat_lamp_black"));
        blockFlatLampBlack.setRegistryName("block_flat_lamp_black");
        GameRegistry.register(blockFlatLampBlack);
        itemFlatLampBlack = new ItemBlock(blockFlatLampBlack);
        itemFlatLampBlack.setRegistryName(blockFlatLampBlack.getRegistryName());
        GameRegistry.register(itemFlatLampBlack);*/

        blockFlatLampTransparent = (BlockFlatLampTransparent) (new BlockFlatLampTransparent().setUnlocalizedName("blocks.block_flat_lamp_transparent"));
        blockFlatLampTransparent.setRegistryName("block_flat_lamp_transparent");
        GameRegistry.register(blockFlatLampTransparent);
        itemFlatLampTransparent = new ItemBlock(blockFlatLampTransparent);
        itemFlatLampTransparent.setRegistryName(blockFlatLampTransparent.getRegistryName());
        GameRegistry.register(itemFlatLampTransparent);
    }

    public static void initCommon() {
    }

    public static void postInitCommon() {
    }

}