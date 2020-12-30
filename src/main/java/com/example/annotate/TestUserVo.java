package com.example.annotate;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @ClassName TestUserVo
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/29
 * @Version V1.0
 **/
@CheckTimeInterval(startTime = "oneTime",endTime = "twoTime",message = "开始时间不能大于结束时间")
public class TestUserVo {
    private int id;
    @NotEmpty(message = "姓名不能为空")
    @Length(min=1,max=10,message = "姓名必须是1—10字符")
    private String name;
    @Min(message = "最小为1",value=1)
    @Max(message = "最大为99",value=99)
    private int age;
    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "^[1]([3-9])[0-9]{9}$", message = "手机号格式不正确")
    private String phone;
    @Length(max=100,message = "爱好长度在100字符以内")
    private String habby;
    @NotNull
    private Date oneTime;
    @NotNull
    private Date twoTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHabby() {
        return habby;
    }

    public void setHabby(String habby) {
        this.habby = habby;
    }

    public Date getOneTime() {
        return oneTime;
    }

    public void setOneTime(Date oneTime) {
        this.oneTime = oneTime;
    }

    public Date getTwoTime() {
        return twoTime;
    }

    public void setTwoTime(Date twoTime) {
        this.twoTime = twoTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestUserVo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", habby='").append(habby).append('\'');
        sb.append(", oneTime=").append(oneTime);
        sb.append(", twoTime=").append(twoTime);
        sb.append('}');
        return sb.toString();
    }
}
