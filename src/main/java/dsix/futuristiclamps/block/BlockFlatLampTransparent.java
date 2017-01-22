package dsix.futuristiclamps.block;

import javax.annotation.Nullable;

import dsix.futuristiclamps.StartupCommon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

public class BlockFlatLampTransparent extends Block
{
    public static final AxisAlignedBB BLOCK_DOWN = new AxisAlignedBB(0.06499999761581421D, 0.0D, 0.06499999761581421D, 0.9350000023841858D, 0.0625D, 0.9350000023841858D);
    public static final AxisAlignedBB BLOCK_UP = new AxisAlignedBB(0.06499999761581421D, 1.0D, 0.06499999761581421D, 0.9350000023841858D, 0.9399999976158142D, 0.9350000023841858D);
    public static final AxisAlignedBB BLOCK_NORTH = new AxisAlignedBB(0.06350000202655792D, 0.06350000202655792D, 0.003000000026077032D, 0.9350000023841858D, 0.9350000023841858D, 0.06350000202655792D);
    public static final AxisAlignedBB BLOCK_SOUTH = new AxisAlignedBB(0.06350000202655792D, 0.06350000202655792D, 0.9399999976158142D, 0.9350000023841858D, 0.9350000023841858D, 0.9980000257492065D);
    public static final AxisAlignedBB BLOCK_WEST = new AxisAlignedBB(0.0D, 0.0625D, 0.0625D, 0.0625D, 0.9350000023841858D, 0.9350000023841858D);
    public static final AxisAlignedBB BLOCK_EAST = new AxisAlignedBB(0.9430000185966492D, 0.0625D, 0.9350000023841858D, 0.9950000047683716D, 0.9350000023841858D, 0.0625D);

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    private boolean ignoreSimilarity;

    public BlockFlatLampTransparent()
    {
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        setHardness(0.3F);
        setLightLevel(1.0F);

        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING)) {
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

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();
        if ((this == Blocks.GLASS) || (this == StartupCommon.blockFlatLampTransparent))
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return canPlaceBlock(worldIn, pos, facing.getOpposite()) ? getDefaultState().withProperty(FACING, facing.getOpposite()) : getDefaultState().withProperty(FACING, EnumFacing.DOWN);
    }
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 0x7));
    }
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }
    @Override
    public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
        return EnumBlockRenderType.MODEL;
    }
}