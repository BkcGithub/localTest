package reflect;

public class UserInfo {
    private String userName;
    private Integer age;
    public String school;

    public void getMyInfo(String mName, String mBirth, Integer age) {
        System.out.println("我是一个来自" + mBirth + "的名叫：" + mName + "的" + age
            + "岁的选手");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
