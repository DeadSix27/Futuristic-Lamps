package dsix.futuristiclamps.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockFlatLampVariants extends ItemBlock
{

    public ItemBlockFlatLampVariants(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        BlockFlatLampVariants.EnumColour colour = BlockFlatLampVariants.EnumColour.byMetadata(stack.getMetadata());
        return super.getUnlocalizedName() + "." + colour.toString();
    }
}