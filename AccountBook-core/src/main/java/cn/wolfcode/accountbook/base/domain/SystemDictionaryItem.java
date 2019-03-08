package cn.wolfcode.accountbook.base.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class SystemDictionaryItem extends BaseDomain {
    //数据字典明细对应的分类id
    private Long parentId;

    //数据字典明细显示名称
    private String title;

    //数据字典明细在该分类中的排序
    private Integer sequence = 0;

    public String getJsonString(){
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        map.put("id",getId());
        map.put("title",title);
        map.put("sequence",sequence);
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}