package daumtrack.oop.filemonitor.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghost9087 on 15. 10. 2..
 */
public class FileItem {
    private String name;
    private List<String> parentList = new ArrayList<String>();
    private long size = 0;

    public void setName(String name) {
        this.name = name;
    }
    public void addParentPath(String parent){
        if (!parent.isEmpty())
            parentList.add(parent);
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getParentPath() {
        String parentPath = "";

        for(String path : parentList){
            parentPath += path+"/";
        }
        return parentPath;
    }

    @Override
    public String toString() {
        return getParentPath() +  getName() + ":" +getSize();
    }
}
