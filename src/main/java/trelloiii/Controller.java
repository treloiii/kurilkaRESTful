package trelloiii;

import com.sun.javafx.binding.StringFormatter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sql.ResultedQuery;

import java.io.FileOutputStream;
import java.sql.Timestamp;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    ResultedQuery rq;
    @RequestMapping("/upload/img")
    public String uploadImage(@RequestParam("file") String file,@RequestParam(value = "name")String name,@RequestParam(value = "message") String message){
        try {
            byte[] imageByte= Base64.decodeBase64(file);
            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            String fileName=String.valueOf(timestamp.getTime());
            String directory="/home/std/kurilkahttp/static/"+fileName+".jpg";
            new FileOutputStream(directory).write(imageByte);
            String pointer="','";
            String query="INSERT INTO kurilka_msg (name,message,img,img_message) VALUES('"+name+pointer+message+pointer+fileName+pointer+message+"');";
            rq.voidQuery(query);
            return fileName;
        }
        catch(Exception e) {
            e.printStackTrace();
            return "error = "+e;
        }
    }

    @RequestMapping("/new/message")
    public String newMessage(@RequestParam("name") String name,@RequestParam("message") String message){
        try {
            String pointer = "','";
            String query = "INSERT INTO kurilka_msg (name,message,img,img_message) VALUES('" + name + pointer + message + pointer + "" + pointer + message + "');";
            rq.voidQuery(query);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "error"+e;
        }
    }

}
