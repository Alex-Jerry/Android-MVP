package cn.com.jerry.androidmvp.ui.home.domain;

import java.io.Serializable;

public class DeviceVO implements Serializable {
    public String client_id;
    public String device_brand;
    public Long device_id;
    public String device_model;
    public String device_name;
    public String device_platform;
    public String device_version;
    public String live_id;
    public Long user_id;
    public String online;
    public boolean is_admin;
    public String member_name;
    public boolean photo_enable;
    public boolean video_enable;
    public boolean control_enable;
    public String member_id;
    public String device_header;

    public String getDevice_header() {
        return device_header;
    }

    public void setDevice_header(String device_header) {
        this.device_header = device_header;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String device_brand) {
        this.device_brand = device_brand;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_platform() {
        return device_platform;
    }

    public void setDevice_platform(String device_platform) {
        this.device_platform = device_platform;
    }

    public String getDevice_version() {
        return device_version;
    }

    public void setDevice_version(String device_version) {
        this.device_version = device_version;
    }

    public String getLive_id() {
        return live_id;
    }

    public void setLive_id(String live_id) {
        this.live_id = live_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String isOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public boolean isPhoto_enable() {
        return photo_enable;
    }

    public void setPhoto_enable(boolean photo_enable) {
        this.photo_enable = photo_enable;
    }

    public boolean isVideo_enable() {
        return video_enable;
    }

    public void setVideo_enable(boolean video_enable) {
        this.video_enable = video_enable;
    }

    public boolean isControl_enable() {
        return control_enable;
    }

    public void setControl_enable(boolean control_enable) {
        this.control_enable = control_enable;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "DeviceVO{" +
                "client_id='" + client_id + '\'' +
                ", device_brand='" + device_brand + '\'' +
                ", device_id=" + device_id +
                ", device_model='" + device_model + '\'' +
                ", device_name='" + device_name + '\'' +
                ", device_platform='" + device_platform + '\'' +
                ", device_version='" + device_version + '\'' +
                ", live_id='" + live_id + '\'' +
                ", user_id=" + user_id +
                ", online='" + online + '\'' +
                ", is_admin=" + is_admin +
                ", member_name='" + member_name + '\'' +
                ", photo_enable=" + photo_enable +
                ", video_enable=" + video_enable +
                ", control_enable=" + control_enable +
                ", member_id='" + member_id + '\'' +
                ", device_header='" + device_header + '\'' +
                '}';
    }
}