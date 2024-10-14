package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString(), team.toString());
    }

    @Test
    public void equals_returns_correct_value(){
        //case 1: same object
        Team obj = team; 
        assert(team.equals(obj)); 

        //case 2:different class 
        class differentClass {
            public String name;
            public differentClass(String name) {
                this.name = name;
            }
        };  
        differentClass diff_object = new differentClass("test-team");
        assertEquals(team.equals(diff_object), false); 

        //case 3: 
        //TT
        Team obj2 = new Team("test-team"); 
        assert(team.equals(obj2)); 
        //TF
        Team obj3 = new Team("test-team"); 
        obj3.addMember("ryan"); 
        assertEquals(team.equals(obj3), false); 
        //FT
        Team obj4 = new Team("a-different-name"); 
        assertEquals(team.equals(obj4), false); 
        //FF
        Team obj5 = new Team("a-different-name"); 
        obj5.addMember("ryan");
        assertEquals(team.equals(obj5), false); 

    }
    @Test
    public void hashcode_returns_correct_value(){
        //tests below based on the starter code provided in the project instructions. 
        Team obj1 = new Team();
        obj1.setName("test-team");
        obj1.addMember("ryan");
        Team obj2 = new Team();
        obj2.setName("test-team");
        obj2.addMember("ryan");
        assertEquals(obj1.hashCode(), obj2.hashCode());
     
        Team obj3 = new Team();
        int result = obj3.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
