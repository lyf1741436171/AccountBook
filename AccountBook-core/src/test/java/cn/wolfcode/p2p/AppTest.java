package cn.wolfcode.p2p;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * Unit test for simple ApplicationCoreConfig.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {


    }


    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextLong() );

        String string = UUID.randomUUID().toString();
        System.out.println(string);
       // System.out.println(MD5.encode("小雪000000"));
       // System.out.println(MD5.encode("小林000000"));
    }

}

