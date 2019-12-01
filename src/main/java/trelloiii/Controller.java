package trelloiii;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.sql.Timestamp;

@RestController
@CrossOrigin
public class Controller {

    @RequestMapping("/upload/img")
    public String uploadImage(@RequestParam("file") String file){
        try
        {
            //This will decode the String which is encoded by using Base64 class
            byte[] imageByte= Base64.decodeBase64(file);
            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            String fileName=String.valueOf(timestamp.getTime());
            String directory="/home/std/kurilkahttp/static/"+fileName+".jpg";

            new FileOutputStream(directory).write(imageByte);
            return fileName;
        }
        catch(Exception e)
        {
            return "error = "+e;
        }
    }
}
