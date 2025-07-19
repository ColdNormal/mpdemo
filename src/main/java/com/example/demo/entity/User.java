/**
 * @Package com.example.demo.entity
 * @author atom.hu
 * @date 2025/7/16 21:45
 * @version V1.0
 */
package com.example.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long createTime; //TODO 用包装类型Long，不要用基本类型long，因为用Builder传入user时，如果没有填写createTime会默认传入createTime=0
    private Long updateTime;
//    private Long version;
}
