package com.palarczyk.socialmedia.service;

import com.palarczyk.socialmedia.domain.File;
import com.palarczyk.socialmedia.domain.Post;
import com.palarczyk.socialmedia.repository.FileRepository;
import com.palarczyk.socialmedia.exception.FileStorageException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(File file){
        fileRepository.save(file);
    }

    public File findFileById(Long id){
        return fileRepository.findFileById(id);
    }

    public File findFileByFileNameAndDateOfRecording(String name, LocalDateTime date){
        return fileRepository.findFileByFileNameAndDateOfRecording(name,date);
    }

    public void delete(File file){
        fileRepository.delete(file);
    }

    public void deleteFile(Long id, String name) throws IOException {
        String fileDri = "src/main/webapp/images/"+id+"/"+name;
        String folderDri = "src/main/webapp/images/"+id;
        Path pathFile = Paths.get(fileDri);
        Path pathFolder = Paths.get(folderDri);
        Files.deleteIfExists(pathFile);
        Files.deleteIfExists(pathFolder);
    }

    public List<File> findAll(){
        return fileRepository.findAll();
    }

    public List<File> findFiles(List<Post> posts){
        return posts.stream().map(e->fileRepository.findFileById(e.getFileId()))
                .collect(Collectors.toList());
    }

    public File storeFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        if(fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        File dbFile = new File(fileName, file.getContentType());

        return fileRepository.save(dbFile);
    }

    public void saveFileInDisk(MultipartFile multipartFile, File file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String uploadDri = "src/main/webapp/images/"+file.getId();
        Path uploadPath = Paths.get(uploadDri);
        if(!Files.exists(uploadPath))
            Files.createDirectories(uploadPath);
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Nie można załadować pliku "+fileName);
        }
    }
}
