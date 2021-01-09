package baitap.model;

public class MailBox {
    String languages;
    int size;
    String filter;
    String signature;

    public MailBox(String languages, int size, String filter, String signature) {
        this.languages = languages;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public MailBox() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
