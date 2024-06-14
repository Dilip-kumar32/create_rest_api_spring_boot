package com.api.book.bootrestbook.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    //public final String upload_dir="E:\\SpringBoot_for_learning\\bootrestbook\\src\\main\\resources\\static\\image";
    public final String upload_dir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
    public FileUploadHelper()throws IOException
    {
        
    }
    public boolean uploadFile(MultipartFile multipartfile)
    {
        boolean f=false;
        try{
            Files.copy(multipartfile.getInputStream(), Paths.get(upload_dir+File.separator+multipartfile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
    
}
