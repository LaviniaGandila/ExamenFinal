package ObjectData;

import java.util.Map;

public class CheckoutObject {
    private String country;
    private String city;
    private String address1;
    private String zipCode;
    private String phoneNumber;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CheckoutObject (Map<String,String> testData) {
        prepareObject(testData);
    }

    private void prepareObject (Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "country":
                    setCountry(testData.get(key));
                    break;

                case "city":
                    setCity(testData.get(key));
                    break;

                case "address1":
                    setAddress1(testData.get(key));
                    break;

                case "zipCode":
                    setZipCode(testData.get(key));
                    break;

                case "phoneNumber":
                    setPhoneNumber(testData.get(key));
                    break;
            }
        }
    }
}
