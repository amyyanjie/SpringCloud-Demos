package com.amy.cloud.amycloudact.controller;


import feign.*;




/**
 * @Author: yanjie
 * @Description:
 * @Date: 2020/05/27 16:59
 */
public class FeignTest {

    interface BookService {
        @RequestLine("user/get?userId={userId}")
        String getUserName(@Param("userId") String userId);

        @RequestLine("POST /book/post")
        @Headers("Content-Type: application/json")
        @Body("id: {id}, name: {name}")
        String post(String id, String name);
    }

    public static void main(String[] args) {
        BookService bs = Feign.builder()
                .options(new Request.Options(2000, 6000))
                .target(BookService.class, "http://localhost:7200");
        String result = bs.getUserName( "as");
        System.out.println(result);
//        result = bs.post("12345", "spring feign");
//        System.out.println(result);

//        IGitHubFeign github = Feign.builder()
//                .decoder(new GsonDecoder())
//                .target(IGitHubFeign.class, "https://api.github.com");
//
//        // Fetch and print a list of the contributors to this library.
//        List<IGitHubFeign.Contributor> contributors = github.contributors("OpenFeign", "feign");
//        for (IGitHubFeign.Contributor contributor : contributors) {
//            System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
//        }
    }


}
