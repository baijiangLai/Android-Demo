package com.lixiang.rxjava_retrofit_mvp_demo.bean;

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

        public String getCarprefix() {
            return carprefix;
        }

        public void setCarprefix(String carprefix) {
            this.carprefix = carprefix;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

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
