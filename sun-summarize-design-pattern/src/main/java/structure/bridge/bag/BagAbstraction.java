package structure.bridge.bag;


import structure.bridge.material.Material;

public abstract class BagAbstraction {
	protected Material material;

	public void setMaterial(Material material) {
		this.material = material;
	}

	public abstract void pick();
}
