package adoptme.adapter;

import adoptme.pet.*;

public class ExoticAnimalAdapter {
	/**
	 * Method to adapt exotic animal information into a proper exotic
	 * animal object.
	 * @param raw - Data used to create the exotic animal object.
	 * @return
	 */
    public ExoticAnimal adapt(RawExoticAnimal raw) {
        return new ExoticAnimal(
            raw.uniqueId,
            raw.animalName,
            raw.subSpecies,
            raw.yearsOld
        );
    }
}
