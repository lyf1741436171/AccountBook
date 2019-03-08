package cn.wolfcode.accountbook.base.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class SystemDictionary extends BaseDomain {
    // 数据字典分类编码
    private String sn;

    // 数据字典分类名称
    private String title;






    public String getJsonString(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",getId());
        map.put("sn",sn);
        map.put("title",title);
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}