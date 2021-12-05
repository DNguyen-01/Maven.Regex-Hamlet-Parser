import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testFindHoratio() {
        //given
        //when
        int actual = hamletParser.findHoratio();
        //then
        Assert.assertEquals(158,actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        //given
        //when
        hamletParser.changeHamletWithLeon();
        //then
        Assert.assertFalse(hamletParser.getHamletData().contains("HAMLET"));
        Assert.assertFalse(hamletParser.getHamletData().contains("Hamlet"));

    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        //when
        hamletParser.changeHoratioWithTariq();
        //then
        Assert.assertFalse(hamletParser.getHamletData().contains("HORATIO"));
        Assert.assertFalse(hamletParser.getHamletData().contains("Horatio"));
    }


    @Test
    public void testFindHamlet() {
        //given
        //when
        int expected = 472;
        int actual = hamletParser.findHamlet();
        //then
        Assert.assertEquals(expected,actual);
    }


}