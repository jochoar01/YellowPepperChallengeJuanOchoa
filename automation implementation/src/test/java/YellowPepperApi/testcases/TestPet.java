package YellowPepperApi.testcases;

import Data.DataGenerator;

import YellowPepperApi.model.Pet;
import YellowPepperApi.utiltest.BaseTestYellowPepper;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestPet extends BaseTestYellowPepper {

    public static final String PET_API = "pet";
    public static final String STATUS = "findByStatus?status=";
    public static final String TAGS = "findByTags?tags=";

    public static Logger log = LogManager.getLogger(TestPet.class);


    @Test(priority = 1)
    public static void endToEndPet() {
        DataGenerator coreAPI = new DataGenerator();

        Pet pet = coreAPI.createPet();
        Pet petModified = coreAPI.createPet();

        Response postResponse = postApi(pet, PET_API);
        Pet postBody = postResponse.as(Pet.class);
        assertEquals("available", postResponse.as(Pet.class).getStatus());
        assertEquals(200, postResponse.getStatusCode());

        Response getResponseById = getApi(PET_API + "/" + (int) postBody.getId());
        assertEquals(200, getResponseById.getStatusCode());

        Response getResponseByStatus = getApi(PET_API + "/" + STATUS + postBody.getStatus());
        assertEquals(200, getResponseByStatus.getStatusCode());

        Response getResponseByTags = getApi(PET_API + "/" + TAGS + postBody.getTags().get(0).getId());
        assertEquals(200, getResponseByTags.getStatusCode());

        Response putResponse = putApi(petModified, PET_API);
        Pet putBody = putResponse.as(Pet.class);
        assertEquals(200, putResponse.getStatusCode());


        Response getResponseAfterPutById = getApi(PET_API + "/" + (int) putBody.getId());
        assertEquals(200, getResponseAfterPutById.getStatusCode());
        assertEquals(putBody.getId(), petModified.getId());
        assertEquals(putBody.getCategory().getId(), petModified.getCategory().getId());
        assertEquals(putBody.getCategory().getName(), petModified.getCategory().getName());
        assertEquals(putBody.getName(), petModified.getName());
        assertEquals(putBody.getPhotoUrls(), petModified.getPhotoUrls());
        assertEquals(putBody.getTags().get(0).getId(), petModified.getTags().get(0).getId());
        assertEquals(putBody.getTags().get(0).getName(), petModified.getTags().get(0).getName());
        assertEquals(putBody.getStatus(), petModified.getStatus());

        Response deleteResponse = deleteApi(PET_API + "/" + (int) putBody.getId());
        assertEquals(200, deleteResponse.getStatusCode());

        Response getResponseAfterDeleteById = getApi(PET_API + "/" + (int) postBody.getId());
        assertEquals(404, getResponseAfterDeleteById.getStatusCode());


    }

}












