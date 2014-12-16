package file;

import java.io.File;

/**
 * *****************************************
 * 文件名称: ${type_name} <br/>
 * 系统名称: 直销银行V1.0
 * 模块名称: WEB业务平台帐户类
 * 软件版权: 信雅达系统工程股份有限公司
 * 功能说明: ${todo} ADD FUNCTION. <br/>
 * 系统版本: 1.0.0.1
 * 开发人员:  Terrance
 * 开发时间: 2014/12/1 13:41 <br/>
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 * V3.0.0.2 20130530-01  XXXX        提示报错 M201305300011
 * *******************************************
 */
public class deleteFai {
    public static void main(String[] args) {
        File file = new File("C:\\jobRelated\\IdeaProjects\\direct-bank");
        deleteFiles(file);
        System.out.println("delete successfully");
    }

    public static void deleteFiles(File file){
        if(file.isDirectory()){
            for (int i = 0; i < file.listFiles().length; i++) {
                deleteFiles(file.listFiles()[i]);

            }
        }
        file.delete();
        System.out.println("delete file "+ file.getAbsolutePath()+"\\"+ file.getName());
    }
}
