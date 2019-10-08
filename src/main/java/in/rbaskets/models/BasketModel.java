

package in.rbaskets.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BasketModel {
    @JsonProperty("forward_url")
    private String forward_url;
    @JsonProperty("proxy_response")
    private boolean proxy_response;
    @JsonProperty("insecure_tls")
    private boolean insecure_tls;
    @JsonProperty("expand_path")
    private boolean expand_path;
    @JsonProperty("capacity")
    private int capacity;

    public BasketModel() {

    }

    public BasketModel(String forward_url, boolean proxy_response, boolean insecure_tls, boolean expand_path, int capacity) {
        this.forward_url = forward_url;
        this.proxy_response = proxy_response;
        this.insecure_tls = insecure_tls;
        this.expand_path = expand_path;
        this.capacity = capacity;
    }




    @Override
    public String toString() {
        return "BasketModel{" +
                "forward_url='" + forward_url + '\'' +
                ", proxy_response=" + proxy_response +
                ", insecure_tls=" + insecure_tls +
                ", expand_path=" + expand_path +
                ", capacity=" + capacity +
                '}';
    }

    public void setForward_url(String forward_url) {
        this.forward_url = forward_url;
    }

    public void setProxy_response(boolean proxy_response) {
        this.proxy_response = proxy_response;
    }

    public void setInsecure_tls(boolean insecure_tls) {
        this.insecure_tls = insecure_tls;
    }

    public void setExpand_path(boolean expand_path) {
        this.expand_path = expand_path;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
