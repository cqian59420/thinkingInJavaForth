package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Terrance on 2014/12/21 2014/12/21.
 * ${todo} describe
 */

//总之，如果当前方法throw异常，上级必须处理
public class FileRead {

    public void readFile(String fileName)  {
        File file = new File(fileName);
        try {
            InputStream inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            //throw new Exception("a");如果不抛出，上级也不需要接受
            //如果抛出，当前方法也必须throw，上级必须处理
        }

    }

    public void readFile2(String fileName) throws FileNotFoundException {

        File file = new File(fileName);


        InputStream inputStream = new FileInputStream(file);


    }
}
