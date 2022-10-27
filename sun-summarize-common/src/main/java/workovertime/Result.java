package workovertime;

import lombok.Data;

import java.util.List;

/**
 * Result
 *
 * @summary Result
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年10月26日 20:02:00
 */
@Data
public class Result {

    private String code;

    private String msg;

    private List<CheckTime> data;

    @Data
    public static class CheckTime {
        private String employeeCode;
        private String employeeName;
        private String checkDate;
        private String checkinTime;
        private String checkoutTime;
        private String duration;
    }
}
