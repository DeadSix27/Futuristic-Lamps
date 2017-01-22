package dsix.futuristiclamps.block;

import javax.annotation.Nullable;

import dsix.futuristiclamps.StartupCommon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockFlatLampVariants extends Block
{
    public static final AxisAlignedBB BLOCK_DOWN = new AxisAlignedBB(0.06499999761581421D, 0.0D, 0.06499999761581421D, 0.9350000023841858D, 0.0625D, 0.9350000023841858D);
    public static final AxisAlignedBB BLOCK_UP = new AxisAlignedBB(0.06499999761581421D, 1.0D, 0.06499999761581421D, 0.9350000023841858D, 0.9399999976158142D, 0.9350000023841858D);
    public static final AxisAlignedBB BLOCK_NORTH = new AxisAlignedBB(0.06350000202655792D, 0.06350000202655792D, 0.003000000026077032D, 0.9350000023841858D, 0.9350000023841858D, 0.06350000202655792D);
    public static final AxisAlignedBB BLOCK_SOUTH = new AxisAlignedBB(0.06350000202655792D, 0.06350000202655792D, 0.9399999976158142D, 0.9350000023841858D, 0.9350000023841858D, 0.9980000257492065D);
    public static final AxisAlignedBB BLOCK_WEST = new AxisAlignedBB(0.0D, 0.0625D, 0.0625D, 0.0625D, 0.9350000023841858D, 0.9350000023841858D);
    public static final AxisAlignedBB BLOCK_EAST = new AxisAlignedBB(0.9430000185966492D, 0.0625D, 0.9350000023841858D, 0.9950000047683716D, 0.9350000023841858D, 0.0625D);

    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum PROPERTYCOLOUR = PropertyEnum.create("colour", EnumColour.class);

    private boolean ignoreSimilarity;

    public BlockFlatLampVariants()
    {
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        setHardness(0.3F);
        setLightLevel(1.0F);

        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(PROPERTYFACING)) {
            case DOWN:
                return BLOCK_DOWN;
            case UP:
                return BLOCK_UP;
            case EAST:
                return BLOCK_EAST;
            case WEST:
                return BLOCK_WEST;
            case SOUTH:
                return BLOCK_SOUTH;
            case NORTH:
                return BLOCK_NORTH;
        }
        return BLOCK_DOWN;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }


    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();
        if ((this == Blocks.GLASS) || (this == StartupCommon.blockFlatLampVariants))
        {
            if (blockState != iblockstate)
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return (!this.ignoreSimilarity) && (block == this) ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
        //return !((!this.ignoreSimilarity) && (block == this)) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }


    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        return canPlaceBlock(worldIn, pos, side.getOpposite());
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL.facings())
        {
            if (canPlaceBlock(worldIn, pos, enumfacing))
            {
                return true;
            }
        }

        return false;
    }

    protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction) {
        BlockPos blockpos = pos.offset(direction);
        return worldIn.getBlockState(blockpos).isSideSolid(worldIn, blockpos, direction.getOpposite());
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING, PROPERTYCOLOUR});
    }



    @Override
    public int damageDropped(IBlockState state)
    {
        EnumColour enumColour = (EnumColour)state.getValue(PROPERTYCOLOUR);
        return enumColour.getMetadata();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        EnumColour[] allColours = EnumColour.values();
        for (EnumColour colour : allColours) {
            list.add(new ItemStack(itemIn, 1, colour.getMetadata()));
        }
    }


    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        int colourbits = (meta & 0x0c) >> 2;
        EnumColour colour = EnumColour.byMetadata(colourbits);
        return this.getDefaultState().withProperty(PROPERTYCOLOUR, colour).withProperty(PROPERTYFACING, facing);
    }
    @Override
    public int getMetaFromState(IBlockState state)
    {
        EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
        EnumColour colour = (EnumColour)state.getValue(PROPERTYCOLOUR);

        int facingbits = facing.getHorizontalIndex();
        int colourbits = colour.getMetadata() << 2;
        return facingbits | colourbits;
    }
    /*@Override
    public IBlockState getStateFromMeta(int meta)
    {
        int colourbits = (meta & 0x0c) >> 2;
        EnumColour colour = EnumColour.byMetadata(colourbits);
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 0x7)).withProperty(PROPERTYCOLOUR, colour);
    }


    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        int colourbits = (meta & 0x0c) >> 2;
        EnumColour colour = EnumColour.byMetadata(colourbits);
        return this.getDefaultState().withProperty(PROPERTYCOLOUR, colour).withProperty(FACING, facing);
    }*/

    /*
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
    */

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state;
    }


    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumColour colour = EnumColour.byMetadata(meta);
        // find the quadrant the player is facing
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

        return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYCOLOUR, colour);
    }
    /*@Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumColour colour = EnumColour.byMetadata(meta);
        // find the quadrant the player is facing
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

        return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(PROPERTYCOLOUR, colour);
    }
    */

    public static enum EnumColour implements IStringSerializable
    {
        BLACK(0, "black"),
        RED(1, "red"),
        GREEN(2, "green"),
        BROWN(3, "brown"),
        BLUE(4, "blue"),
        PURPLE(5, "purple"),
        CYAN(6, "cyan");
        //LIGHTGRAY(7, "lightgray"),
        //GRAY(8, "gray"),
        //PINK(9, "pink"),
        //LIME(10, "lime"),
        //YELLOW(11, "yellow"),
        //LIGHTBLUE(12, "lightblue");
        //MAGENTA(13, "magenta"),
        //ORANGE(14, "orange");
        //WHITE(15, "white");

        public int getMetadata()
        {
            return this.meta;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumColour byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        private final int meta;
        private final String name;
        private static final EnumColour[] META_LOOKUP = new EnumColour[values().length];

        private EnumColour(int i_meta, String i_name)
        {
            this.meta = i_meta;
            this.name = i_name;
        }

        static
        {
            for (EnumColour colour : values()) {
                META_LOOKUP[colour.getMetadata()] = colour;
            }
        }
    }
}