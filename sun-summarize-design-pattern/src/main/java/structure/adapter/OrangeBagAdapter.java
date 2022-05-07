package structure.adapter;

import product.bag.AppleBag;
import product.bag.OrangeBag;

public class OrangeBagAdapter extends OrangeBag {
	private AppleBag appleBag;

	public OrangeBagAdapter(AppleBag appleBag) {
		this.appleBag = appleBag;
	}

	@Override
	public void pack() {
		appleBag.pack();
	}
}
