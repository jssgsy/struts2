package com.univ.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: liuml
 * @date: 2015年7月28日 上午9:55:19
 * @version: 1.0
 * @description: 文件上传
 */

public class FileUploadAction extends ActionSupport {
    /**
     * 要获取前台上传文件的类型和文件名，这里需要注意一个命名规范：如果File的对象是xxx，则用来接收文件名的属性必须为xxxFileName,
     * 而用来接收文件类型的属性必须为xxxContentType。(如下的uploadFileName和uploadContentType)
     */
    private File upload;
    private String uploadFileName;//自带有后缀名，写法有讲究，见上
    private String uploadContentType;//写法有讲究

    private String savePath;//这是action的参数，在配置文件中配置。用于指定上传文件的存放路径。

    //获得配置文件中参数savePath的值只需要为之设置setter方法，注意此时savePath的值没法传到前台页面上，
    //因为它的值是通过action配置参数获得的,经试验，即使赋予setter方法，前台也取不到
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String execute() throws IOException {
        /**
         * 注意：一定要先判断一下存放上传文件的路径是否存在。所以这里的FileOutputStream的构造函数用FileOutputStream(File file),
         * 而里面的参数file用File的构造函数new File(File file,String path)
         */
        File file = new File(this.getSavePath());
        if (!file.isDirectory()) {//如果给定的路径不是文件夹的形式
            file.mkdirs();//创建文件夹
        }
        FileOutputStream fos = new FileOutputStream(new File(file, File.separator + getUploadFileName()));
        FileInputStream fis = new FileInputStream(getUpload());
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();
        return SUCCESS;
    }

    //获取文件上传保存的位置
    private String getSavePath() {
        return savePath;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
//		System.out.println("uploadContentType: "+uploadContentType);
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }


}


