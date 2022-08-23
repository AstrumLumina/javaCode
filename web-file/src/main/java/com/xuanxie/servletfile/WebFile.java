package com.xuanxie.servletfile;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class WebFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!ServletFileUpload.isMultipartContent(req)){
            return ;//普通表单,直接返回
        }
        //以下为处理二进制文件

        //创建上传文件的保存路径,建议在web-inf路径下:用户无法直接访问安全
        String uploadPath =this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if(!uploadFile.exists()){
            uploadFile.mkdir();//创建这个目录
        }
        //缓存 临时文件
        //临时路径,假如文件的大小超过了预期的大小,我们就把他放到一个临时文件中,过几天就自动删除
        //或者提醒用户将文件转存为永久文件
        String tempPath=this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tempFile = new File(tempPath);
        if(!tempFile.exists()){
            tempFile.mkdir();
        }
        /*
        {//测试代码,用于理解File类的方法
        //File的对象既可以时文件也可以时目录
            if(tmpFile.isDirectory()){
                System.out.println("这是一个目录 :"+tmpPath);
            }else if(tmpFile.isFile()){
                System.out.println("这是一个文件 :"+tmpPath);
            }else if(tmpFile.exists()){
                System.out.println("这是既不是文件,也不是目录 :"+tmpPath);
            }
        }
        * */

        //处理上传文件,通过流来获取,可以通过request.getInputStream()来操作,但很麻烦,需要自己
        //将的到的二进制流进行解码,将数据提取初来,非常麻烦
        //可以使用apache的文件上传组来实现 common-fileupload,它需要commons-io组件


        //1.创建DiskFileItemFactory对象,处理文件上传的路径和大小限制
        /*ServletFileUpload 负责处理上传文件的的文件数据,并将表单中的每个输入项封装为一个FileItem对象.
         *在使用setvletFileUpload对象解析请求时需要DiskFileItemFactory对象
         * 所以我们需要在进行解析工作前构造好DiskFileItemFactory对象,
         * 通过ServletFileUpload对象的构造方法或者setFileItemFactory()方法设置
         * SetvletFileUpload对象的fileItemFctory对象
         * */
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //通过这个工厂设置一个缓冲区,当文件大于这个缓冲区时,就把他放到临时文件夹中
        //若不设置,则使用默认值
        factory.setSizeThreshold(1024*1024);//缓冲区大小为1M,即限制上传文件的大小
        factory.setRepository(tempFile);//临时文件的保存目录,需要一个File

        //2.获取ServletFileUpload对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        //以下都有默认值,可以不设置
        //监听文件的上传进度
        upload.setProgressListener(new ProgressListener() {
            @Override
            //pBytesRead:已经读取到的文件大小
            //pContentLength:文件总大小
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("总大小: "+pContentLength+" 已上传 : "+pBytesRead);
            }
        });
        //处理乱码问题
        upload.setHeaderEncoding("UTF-8");
        //设置单个文件的最大值
        upload.setFileSizeMax(1024*1024*3);
        //设置总共能上传文件的大小
        upload.setSizeMax(1024*1024*100);

        //3.处理文件
        // 把前端的请求解析, 封装成一个FileItem对象,需要从ServletFileUpload对象中获取
        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                //判断上传的文件是普通的表单还是带文件的表单
                if(fileItem.isFormField()){
                    //如果时普通文件,则按普通文件处理
                    String fieldName = fileItem.getFieldName();//前端文件属性名
                    String value = fileItem.getString("UTF-8");
                    //以utf-8 和string类的 方式返回值
                    System.out.println(fieldName+" : "+value );
                }else{//处理保存上传的文件
                    String uploadFileName = fileItem.getName();//文件名,根据浏览器不同,可能带有路径
                    if(uploadFileName==null||uploadFileName.trim().equals("")){
                        continue;
                    }
                    //获取文件名,不带路径
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                   //获取文件的后缀名,可以用于限制上传文件的类型
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

                    /*网络传输的东西都需要序列化
                    * pojo(实体类)如果想要在多个电脑上运行 传输 就需要把对象都序列化,
                    * 继承 interface serializable接口以实现
                    * implements Serializable :标记接口,是本地方法(native)
                    * JNI编程:Java native interface
                    * */

                    //为防止文件名重复导致的文件覆盖,为文件生成一个随机文件名 文件夹名
                    String uuidPath = UUID.randomUUID().toString();

                    //设置文件存储路径
                    String realPath=uploadPath+"\\"+uuidPath;
                    //为每个文件上传一个文件夹
                    File realPathFile=new File(realPath);
                    if(!realPathFile.exists()){
                        realPathFile.mkdir();
                    }


                    //文件传输
                    //将接收到的数据保存到以上文件夹中
                    //获取上传文件的输入流
                    InputStream inputStream = fileItem.getInputStream();
                    //建一个文件输出流
                    FileOutputStream fileOutputStream = new FileOutputStream(realPath + "\\" + fileName);
                    byte[] buffer=new byte[1024*1024];
                    int len=0;
                    while((len=inputStream.read(buffer))>0){
                        fileOutputStream.write(buffer,0,len);
                    }
                    //文件上传保存完毕,关闭输出流,输入流
                    fileOutputStream.close();
                    inputStream.close();
                    req.setAttribute("message","文件上传成功");
                    System.out.println("文件上传成功");

                }
            }
            req.getRequestDispatcher("/info.jsp").forward(req,resp);

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
