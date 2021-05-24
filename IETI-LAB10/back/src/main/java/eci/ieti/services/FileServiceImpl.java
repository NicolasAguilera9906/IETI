package eci.ieti.services;

import eci.ieti.persistence.FilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FilePersistence filePersistence;

    @Override
    public GridFsResource getFileByName(String filename) throws IOException {
        return filePersistence.getFileByName(filename);
    }

    @Override
    public void handleFileUpload(MultipartFile file) throws IOException {
        filePersistence.handleFileUpload(file);
    }
}
