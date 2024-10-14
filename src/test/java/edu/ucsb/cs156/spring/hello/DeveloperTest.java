package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("divyani", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test 
    public void getGithubId_returns_correct_githubId(){
        assertEquals("divyanipunj", Developer.getGithubId()); 
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f24-08", t.getName());

        assertTrue(t.getMembers().contains("divyani"), "team should contain divyani"); 
        assertTrue(t.getMembers().contains("Oscar"), "team should contain Oscar"); 
        assertTrue(t.getMembers().contains("Mike"), "team should contain Mike");
        assertTrue(t.getMembers().contains("Caleb"), "team should contain Caleb");  
        assertTrue(t.getMembers().contains("Amber"), "team should contain Amber");
        assertTrue(t.getMembers().contains("Christy"), "team should contain Christy");  
    }

}
