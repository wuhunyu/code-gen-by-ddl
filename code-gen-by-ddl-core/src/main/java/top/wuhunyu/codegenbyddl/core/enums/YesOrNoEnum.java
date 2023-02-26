package top.wuhunyu.codegenbyddl.core.enums;

/**
 * yes or no
 *
 * @author wuhunyu
 * @date 2023/02/10 16:30
 **/

public enum YesOrNoEnum {

    /**
     * yes
     */
    YES(0, "yes"),

    /**
     * no
     */
    NO(1, "no");

    /**
     * 状态值
     */
    private final int status;

    /**
     * 状态描述
     */
    private final String desc;

    YesOrNoEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
