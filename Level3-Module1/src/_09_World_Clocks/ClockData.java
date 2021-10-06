package _09_World_Clocks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClockData {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("cityName")
    @Expose
    private String cityName;
    @SerializedName("zoneName")
    @Expose
    private String zoneName;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("gmtOffset")
    @Expose
    private Long gmtOffset;
    @SerializedName("dst")
    @Expose
    private String dst;
    @SerializedName("zoneStart")
    @Expose
    private Long zoneStart;
    @SerializedName("zoneEnd")
    @Expose
    private Long zoneEnd;
    @SerializedName("nextAbbreviation")
    @Expose
    private String nextAbbreviation;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("formatted")
    @Expose
    private String formatted;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(Long gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public Long getZoneStart() {
        return zoneStart;
    }

    public void setZoneStart(Long zoneStart) {
        this.zoneStart = zoneStart;
    }

    public Long getZoneEnd() {
        return zoneEnd;
    }

    public void setZoneEnd(Long zoneEnd) {
        this.zoneEnd = zoneEnd;
    }

    public String getNextAbbreviation() {
        return nextAbbreviation;
    }

    public void setNextAbbreviation(String nextAbbreviation) {
        this.nextAbbreviation = nextAbbreviation;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
