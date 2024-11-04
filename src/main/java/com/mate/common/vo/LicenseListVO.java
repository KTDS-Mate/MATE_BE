package com.mate.common.vo;

import java.util.List;

public class LicenseListVO {


    /**
     * 가이드 라이센스 리스트
     */
    private List<LicenseVO> licenses;

    /**
     * 라이센스 개수 자동으로 업데이트
     */
    public int getLicensesCount() {
        return licenses != null ? licenses.size() : 0;
    }

    public List<LicenseVO> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseVO> licenses) {
        this.licenses = licenses;
    }
}
