import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Reader {
    private BufferedReader br;
    void setBr(String path) throws Exception{
        File file = new File(path);
        br = new BufferedReader(new FileReader(file));
    }
    public String getNext() throws Exception{
        int ini =0;
        char[] buf = new char[2];
        String result = "";
        if(br.ready()){
            br.mark(1024);
            br.read(buf,ini,1);
            if(buf[0]!=',')br.reset();
            br.read(buf,ini,2);
            result = String.valueOf(buf);
        }else {throw new Exception("Finish Reading");}
        return result;
    }
    boolean nextStep() throws Exception{
        if(!(br.ready())) return true;
        return false;
    }
}
