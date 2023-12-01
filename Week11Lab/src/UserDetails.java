/**
 * UserDetails: This is a POJO class to store the user profile details
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/09/2023.
 */
public class UserDetails {
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private String country;
    private String city;
    private String progLanguage;

    UserDetails(String fullName,String emailAddress,String phoneNumber,String country,
                String city,String progLanguage)
    {
        this.fullName=fullName;
        this.emailAddress=emailAddress;
        this.phoneNumber=phoneNumber;
        this.country=country;
        this.city=city;
        this.progLanguage=progLanguage;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getProgLanguage() {
        return progLanguage;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("\nFull Name: ").append(this.fullName).append("\nEmail Address: ").
        append(this.emailAddress).append("\nPhone Number: ").append(this.phoneNumber).
                append("\nCountry: ").append(this.country).append("\nCity: ").
        append(this.city).append("\nPref. Programming Language: ").
        append(this.progLanguage);
        return stringBuilder.toString();
    }
}
