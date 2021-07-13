package chapter10;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class MyClassLoader extends ClassLoader {
    //默认的class存放路径
    private final static Path DEAULT_CLASS_DIR = Paths.get("/Users/duke");

    private final Path classDir;

    public MyClassLoader() {
        super();
        this.classDir = DEAULT_CLASS_DIR;
    }

    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    //将class 文件读入内存
    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The class " + name + " not found.");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class" + name + " occur error.", e);
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //1 读取二进制的数据
        byte[] classBytes = this.readClassBytes(name);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("Can not load the class" + name);
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }


}
