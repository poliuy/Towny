package ca.xshade.bukkit.towny.object;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

/**
 * A class to hold and calculate coordinates in a grid according to the size defined in
 * the static field size.
 * 
 * @author Shade
 */
public class Coord {
	protected static int cellSize = 16;
	protected int x, z;
	
	public Coord(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	public Coord(Coord coord) {
		this.x = coord.getX();
		this.z = coord.getZ();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Coord))
			return false;

		Coord o = (Coord) obj;
		return this.x == o.x && this.z == o.z;
	}

	public static Coord parseCoord(int x, int z) {
		return new Coord(x / getCellSize() - (x < 0 ? 1 : 0), z / getCellSize() - (z < 0 ? 1 : 0));
	}

	public static Coord parseCoord(Entity entity) {
		return parseCoord(entity.getLocation());
	}

	public static Coord parseCoord(Location loc) {
		return parseCoord(loc.getBlockX(), loc.getBlockZ());
	}

	public static Coord parseCoord(Block block) {
		return parseCoord(block.getX(), block.getZ());
	}

	@Override
	public String toString() {
		return getX() + "," + getZ();
	}

	public static void setCellSize(int cellSize) {
		Coord.cellSize = cellSize;
	}

	public static int getCellSize() {
		return cellSize;
	}
}
