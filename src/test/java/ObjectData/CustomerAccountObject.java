package ObjectData;

import java.util.Map;

public class CustomerAccountObject {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String company;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    //facem o metoda care sa mapeze datele din fisierul de resursa cu reprezentarea acestui obiect
    public CustomerAccountObject(Map<String,String> testData) {
        prepareObject(testData);
    }

    private void prepareObject (Map<String, String> testData) {
        for (String key: testData.keySet()){
            switch (key) {
                case "email":
                    setEmail(testData.get(key));
                    break;

                case "password":
                    setPassword(testData.get(key));
                    break;
                case "firstName":
                    setFirstName(testData.get(key));
                    break;

                case "lastName":
                    setLastName(testData.get(key));
                    break;

                case "company":
                    setCompany(testData.get(key));
                    break;
            }
        }
    }
}