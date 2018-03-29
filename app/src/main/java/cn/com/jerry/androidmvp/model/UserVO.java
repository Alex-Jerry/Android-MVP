package cn.com.jerry.androidmvp.model;



import java.io.Serializable;

/**
 * 用户实例类
 *
 * @author Liulei
 */
public class UserVO implements Serializable {

   private String user_mobile;
   private String user_name;
   private String user_token;
   private String complete_info;
   private int user_id;
   private String user_header;

    public String getUser_header() {
        return user_header;
    }

    public void setUser_header(String user_header) {
        this.user_header = user_header;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public String getComplete_info() {
        return complete_info;
    }

    public void setComplete_info(String complete_info) {
        this.complete_info = complete_info;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "user_mobile='" + user_mobile + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_token='" + user_token + '\'' +
                ", complete_info='" + complete_info + '\'' +
                ", user_id=" + user_id +
                ", user_header='" + user_header + '\'' +
                '}';
    }
}
