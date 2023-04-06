package com.lixiang.retrofit_demo.bean;

/**
 * @author laibaijiang
 * @date 2023/4/6
 */
public class LicensePlate {
    private String reason;
    private Result result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public class Result {
        private String carprefix;
        private String province;
        private String city;

        @Override
        public String toString() {
            return "Result{" +
                    "carprefix='" + carprefix + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LicensePlate{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
