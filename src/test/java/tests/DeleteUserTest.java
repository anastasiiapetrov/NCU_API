package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class DeleteUserTest extends BaseTest {
    String endpoint = "/users/";
    String email = getRandomEmail();
    @Test
    public void successDelete(){
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response responsePost = postRequest(endpoint, 201, requestBody);
        Response responseDelete = deleteRequest(endpoint+email ,200);
    }
    @Test
    public void deleteDeletedUser(){
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response responsePost = postRequest(endpoint, 201, requestBody);
        Response responseFirstTime = deleteRequest(endpoint+email ,200);
        Response responseSecondTime = deleteRequest(endpoint+email ,404);
    }
    @Test
    public void deleteNonExistentUser(){
        Response response = deleteRequest(endpoint+"fwfhksdjhfk@gmail.com" ,404);
    }




}
