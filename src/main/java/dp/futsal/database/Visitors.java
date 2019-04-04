package dp.futsal.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "visitors")
public class Visitors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ip;
    private String mobile;
    private String robot;
    private String platform;
    private String browser;
    private String version;
    private String userAgent;
    private int newVisitor;
    private String role;
    private int time;

    public Visitors() {

    }

    public Visitors(String ip, String mobile, String robot, String platform, String browser, String version, String userAgent, int newVisitor, String role, int time) {
        this.ip = ip;
        this.mobile = mobile;
        this.robot = robot;
        this.platform = platform;
        this.browser = browser;
        this.version = version;
        this.userAgent = userAgent;
        this.newVisitor = newVisitor;
        this.role = role;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRobot() {
        return robot;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public int getNewVisitor() {
        return newVisitor;
    }

    public void setNewVisitor(int newVisitor) {
        this.newVisitor = newVisitor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
