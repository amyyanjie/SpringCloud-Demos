package com.amy.cloud.amycloudact.service;

import feign.Param;
import feign.RequestLine;
import lombok.Data;

import java.util.List;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2020/05/27 17:31
 */
public interface IGitHubFeign {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

    @Data
     static class Contributor {
        String login;
        int contributions;
    }

     static class Issue {
        String title;
        String body;
        List<String> assignees;
        int milestone;
        List<String> labels;
    }
}
