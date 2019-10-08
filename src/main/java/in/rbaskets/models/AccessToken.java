package in.rbaskets.models;

public class AccessToken {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {

        return token;
    }
    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                '}';
    }
}
