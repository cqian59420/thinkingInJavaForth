package exception;

import java.io.FileNotFoundException;

/**
 * Created by Terrance on 2014/12/21 2014/12/21.
 * ${todo} describe
 */
public class CallFileRead {


    public void add() {

        FileRead fileRead = new FileRead();

        try {
            fileRead.readFile2("asa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
