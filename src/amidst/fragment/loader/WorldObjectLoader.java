package amidst.fragment.loader;

import amidst.fragment.layer.LayerDeclaration;
import amidst.map.Fragment;
import amidst.minecraft.world.object.WorldObjectProducer;

public class WorldObjectLoader implements FragmentLoader {
	private final LayerDeclaration declaration;
	private final WorldObjectProducer producer;

	public WorldObjectLoader(LayerDeclaration declaration,
			WorldObjectProducer producer) {
		this.declaration = declaration;
		this.producer = producer;
	}

	@Override
	public void load(Fragment fragment) {
		doLoad(fragment);
	}

	@Override
	public void reload(Fragment fragment) {
		doLoad(fragment);
	}

	protected void doLoad(Fragment fragment) {
		fragment.putWorldObjects(declaration.getLayerId(),
				producer.getAt(fragment.getCorner()));
	}
}
