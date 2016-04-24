package my.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Tirex on 24.04.2016.
 */
public class GithubTests {
    @Test
    public void testsCommits() throws IOException {

        Github github = new RtGithub("d4c396dc26f6e712ef87b2fc7aa3e96f2c0c0e8e");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("mvig", "java_pdt28")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());

        }
    }
}
