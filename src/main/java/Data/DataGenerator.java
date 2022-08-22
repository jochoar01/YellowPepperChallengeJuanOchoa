package Data;


import YellowPepperApi.model.Category;
import YellowPepperApi.model.Pet;
import YellowPepperApi.model.Tags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Base Project TestNG + Rest Assured
 * Core API Methods
 *
 * @author Brayhan.Criollo
 */
public class DataGenerator {

    private static Map<String, String> userMap;
    private Logger log = LogManager.getLogger(DataGenerator.class);
    ;

    public Pet createPet() {
        List<String> photos = new ArrayList<>();
        Category category = new Category(1, "Dogs");
        Tags tag =new Tags();
        tag.setId(1);
        tag.setName("Dogs");
        List<Tags> tags = new ArrayList<>();
        tags.add(tag);
        photos.add("Path/Path/path");
        DataGenerator core = new DataGenerator();
        Pet pet = new Pet();
        pet.setId(1);
        pet.setCategory(category);
        pet.setName("Firulais");
        pet.setPhotoUrls(photos);
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }

    public Pet modifiedPet() {
        List<String> photos = new ArrayList<>();
        Category category = new Category(1, "Dogsmodified");
        Tags tag =new Tags();
        tag.setId(1);
        tag.setName("Dogsmodified");
        List<Tags> tags = new ArrayList<>();
        tags.add(tag);
        photos.add("Path/Path/pathmodified");
        DataGenerator core = new DataGenerator();
        Pet pet = new Pet();
        pet.setId(1);
        pet.setCategory(category);
        pet.setName("Firulaismodified");
        pet.setPhotoUrls(photos);
        pet.setTags(tags);
        pet.setStatus("availablemodified");

        return pet;
    }




}