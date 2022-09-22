// import required classes and packages  
package javaTpoint.JavaExample;
import java.io.File;    // for reading file data  
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
// create JacksonConvertJSONToMap class to convert JSON data into Java Map  
public class JacksonConvertJSONToMap {
    // main() method start  
    public static Map<String, Object> jtm(File file) {
        // create instance of the ObjectMapper class to map JSON data  
        ObjectMapper mapper = new ObjectMapper();
        // create instance of the File class   
        File fileObj = file;
        // use try-catch block to convert JSON data into Map  
        try {
            // read JSON data from file using fileObj and map it using ObjectMapper and TypeReference classes  
            Map<String, Object> userData = mapper.readValue(
                    fileObj, new TypeReference<Map<String, Object>>() {
                    });
            // print all key-value pairs
//            System.out.println(userData);
//            System.out.println("Name : " + userData.get("Name"));
//            System.out.println("Mobile : " + userData.get("Mobile"));
//            System.out.println("Designation : " + userData.get("Designation"));
//            System.out.println("Pet : " + userData.get("Pet"));
//            System.out.println("Address : " + userData.get("Address"));
//            Map<String, Object> headerData = (Map<String, Object>) userData.get("header");
//            System.out.println(headerData.get("command"));

            //        Map<String, Object> userData = JacksonConvertJSONToMap.jtm(fileObj);
//        System.out.println(userData);
            return userData;
        } catch (Exception e) {
            // show error message  
            e.printStackTrace();
        }
        return null;
    }
}  