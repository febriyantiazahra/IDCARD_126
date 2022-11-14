/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_pws.pws_126;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Febriyanti Azahra
 */
@Controller
public class controller {
    
    //@ResponseBody
    @RequestMapping ("/getData")
    public String getData(@RequestParam("nama") String text,
                          @RequestParam("tanggal") @DateTimeFormat (pattern="yyyy-MM-dd") Date date,
                          @RequestParam("image") MultipartFile file, Model model)
                          throws IOException {
        
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String newTanggal = tanggal.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
        String img = "data:image/jpeg;base64,".concat(blob);
        
        model.addAttribute("nama", text);
        model.addAttribute("tanggal", newTanggal);
        model.addAttribute("image", img);
        
        return "view";
    }
}
