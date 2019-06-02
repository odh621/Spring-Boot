package kr.ac.ks.twitterclone.upload;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
public class StorageProperties {
    private String uploadedFileLocation = "upload";

    public String getUploadedFileLocation() {
        return uploadedFileLocation;
    }

    public void setUploadedFileLocation(String uploadedFileLocation) {
        this.uploadedFileLocation = uploadedFileLocation;
    }
}
