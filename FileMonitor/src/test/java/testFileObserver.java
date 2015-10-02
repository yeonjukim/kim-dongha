import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by ghost9087 on 15. 10. 2..
 */
public class testFileObserver {
    private String path;

    @Before
    public void setUp(){
        path = "/Users/ghost9087/Documents/Parallels/";
    }

    @Test
    public void 파일이_추가되었을때() throws FileNotFoundException, UnsupportedEncodingException {
        FileObserver observer = new FileObserver(path);
        observer.startObservation();

        PrintWriter printWriter = new PrintWriter(path+"test.test", "UTF-8");
        printWriter.println("test");



    }
}
