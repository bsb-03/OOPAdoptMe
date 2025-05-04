package adoptme.adapter;

import adoptme.pet.*;

public class ExoticAnimalAdapter {
    public ExoticAnimal adapt(RawExoticAnimal raw) {
        return new ExoticAnimal(
            raw.uniqueId,
            raw.animalName,
            raw.subSpecies,
            raw.yearsOld
        );
    }
}
