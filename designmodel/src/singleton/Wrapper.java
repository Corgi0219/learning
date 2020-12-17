package singleton;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Chengliming
 * @create 2020-12-11 3:46 下午
 **/
public class Wrapper {
    public static void main(String[] args) throws IOException {
        ClassReader reader = new ClassReader("singleton.Foo");
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        reader.accept(writer, ClassReader.SKIP_FRAMES);
        Files.write(Paths.get("Foo.class"), writer.toByteArray());
    }
}
