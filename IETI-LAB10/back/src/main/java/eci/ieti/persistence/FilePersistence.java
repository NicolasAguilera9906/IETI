package eci.ieti.persistence;

import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FilePersistence {

    public GridFsResource getFileByName(String filename) throws IOException;

    void handleFileUpload(MultipartFile file) throws IOException;
}
