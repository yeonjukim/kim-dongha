package daumtrack.oop.filemonitor.FileManage;

import daumtrack.oop.filemonitor.Model.FileItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghost9087 on 15. 10. 2..
 */
public class FileListManager {
    private final String path;
    private File file;

    public FileListManager(String path) throws Exception {
        this.path = path;

        init();
    }

    private void init() throws Exception {
        file = new File(path);
        if (!file.isDirectory())
            throw new Exception("경로가 디렉토리가 아닙니다.");

    }

    public List<FileItem> getList() {
        List<FileItem> fileList = getFileListFromFile(file);

        return fileList;
    }

    private List<FileItem> getFileListFromFile(File parentFile) {
        List<FileItem> fileList = new ArrayList<FileItem>();
        File[] files = parentFile.listFiles();

        for (File file : files){
            if (!file.isDirectory()){
                FileItem newItem = new FileItem();
                newItem.setName(file.getName());
                newItem.setSize(file.length());

                if (!file.getParent().equals(path)){
                    String relativePath = file.getParent().replace(path, "");
                    String[] paths = relativePath.split("/");

                    for (String path : paths){
                        newItem.addParentPath(path);
                    }
                }

                fileList.add(newItem);
            }
            else {
                List<FileItem> fileListFromFile = getFileListFromFile(file);

                if (fileListFromFile.size() != 0)
                    fileList.addAll(fileListFromFile);
            }
        }
        return fileList;
    }
}
