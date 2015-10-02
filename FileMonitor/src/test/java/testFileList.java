import daumtrack.oop.filemonitor.FileManage.FileListManager;
import daumtrack.oop.filemonitor.Model.FileItem;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

/**
 * Created by ghost9087 on 15. 10. 2..
 */
public class testFileList {
    @Test
    public void 파일_목록_얻기() throws Exception {
        String path = "/Users/ghost9087/Documents/Parallels/";

        FileListManager manager = new FileListManager(path);

        List<FileItem> list = manager.getList();

        for(FileItem fileItem : list){
            System.out.println(fileItem.toString());
        }

        Assert.assertNotEquals(list.size(), 0);
    }
    @Test(expected = Exception.class)
    public void 인자에_디렉토리_아닌_경로() throws Exception {
        String path = "Users/ghost9087/Documents/ETC/차계부.numbers";

        FileListManager manager = new FileListManager(path);
    }
}
