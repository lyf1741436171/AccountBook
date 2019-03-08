package cn.wolfcode.accountbook;

import cn.wolfcode.accountbook.util.MD5;
import org.junit.Test;

/**
 * Created by admin on 2019/3/8.
 */
public class MD5Test {

    @Test
    public void md5(){
        String encode = MD5.encode("13066341510111111");
        System.out.println(encode);
    }


}
