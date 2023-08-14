package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static sun.misc.RequestProcessor.postRequest;

public class CreateUserTest extends BaseTest{
    String endpoint = "/users";
    @Test
    public void successfulCreateUser() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 201, requestBody);
        Response responseDelete = deleteRequest(endpoint+ "hkkdsddffdsdasjh@gmail.com" ,200);
    }

    @Test
    public void createUserWithoutFullName() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 400, requestBody);
    }

    @Test
    public void createUserWithoutPassword() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 400, requestBody);
    }

    @Test
    public void createUserWithoutEmail() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 400, requestBody);
    }

    @Test
    public void createUserWithLinkTrue() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(true)
                .build();

        Response response = postRequest(endpoint, 201, requestBody);
        Response responseDelete = deleteRequest(endpoint+ "hkkdsddffdsdasjh@gmail.com" ,200);
    }

    @Test
    public void createUserWithGetRequest() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = getRequest(endpoint, 405);
    }




}
