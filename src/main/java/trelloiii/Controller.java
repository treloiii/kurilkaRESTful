package trelloiii;

import Utils.Utils;
import com.sun.javafx.binding.StringFormatter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sql.ResultedQuery;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    ResultedQuery rq;
    @Autowired
    Utils utils;
    @RequestMapping("/upload/img")
    public String uploadImage(@RequestParam("file") MultipartFile file,@RequestParam(value = "name")String name,@RequestParam(value = "message") String message){
        try {
//            byte[] imageByte=file.getBytes();
            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            System.out.println(file.getContentType());
            String fileName=String.valueOf(timestamp.getTime());
            String directory="/home/std/kurilkahttp/static/";
//            new FileOutputStream(directory).write(imageByte);
            System.out.println(utils.fileUpload(directory,fileName,file));
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

    @RequestMapping("get/messages")
    public List<Message> getMessages(){
        try{
            String query="SELECT * FROM kurilka_msg";
            List<Message> res=new ArrayList<>();
            ResultSet rs=rq.getResultSet(query);
            while(rs.next()){
                Message tmp=new Message(rs.getInt("id"),rs.getString("name"),
                                        rs.getString("message"),rs.getString("img"),
                                        rs.getString("img_message"));
                res.add(tmp);
            }
            return res;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
