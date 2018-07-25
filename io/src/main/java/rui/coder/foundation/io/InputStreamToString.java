package rui.coder.foundation.io;

import com.google.common.io.ByteSource;
import com.google.common.io.CharStreams;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 将 {@link InputStream} 转化为 {@link String}
 */
@DisplayName("将 InputStream 转换为 String")
class InputStreamToString {
    private String originalString;
    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        originalString = randomAlphabetic(8);
        inputStream = new ByteArrayInputStream(originalString.getBytes());
    }

    @Nested
    @DisplayName("使用guava")
    class UseGuava {

        @Test
        @DisplayName("利用 ByteSource")
        void leveragingByteSource() throws IOException {


            ByteSource byteSource = new ByteSource() {
                @Override
                public InputStream openStream() throws IOException {
                    return inputStream;
                }
            };
            String text = byteSource.asCharSource(StandardCharsets.UTF_8).read();
            assertEquals(originalString, text);
        }

        @Test
        @DisplayName("利用java 7的特性，自动关闭流")
        void useGuavaAndJava7() throws IOException {
            String text;
            try (final Reader reader = new InputStreamReader(inputStream)) {
                text = CharStreams.toString(reader);
            }
            assertEquals(originalString, text);
        }
    }

    @Nested
    @DisplayName("使用 commons-io")
    class UseApacheCommonsIo {

        @Test
        @DisplayName("使用 IOUtils")
        void useIOUtils() throws IOException {
            String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            assertEquals(originalString, text);
        }

        @Test
        @DisplayName("使用  IOUtils.copy 到 一个StringWriter 中 ")
        void useStringWriter() throws IOException {
            StringWriter stringWriter = new StringWriter();
            IOUtils.copy(inputStream, stringWriter, StandardCharsets.UTF_8.name());
            assertEquals(originalString, stringWriter.toString());
        }
    }

    @Nested
    @DisplayName("使用简单的java")
    class UseSimpleJava {
        @Test
        @DisplayName("最原始的")
        void simple() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    stringBuilder.append((char) c);
                }
            }
            assertEquals(originalString, stringBuilder.toString());
        }

        @Test
        @DisplayName("使用Scanner")
        void scan() {
            String text;
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
                text = scanner.useDelimiter("\\A").next();
            }
            assertEquals(originalString, text);
        }

        @Test
        void useByteArrayOutputSteam() throws IOException {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int read;
            byte[] data = new byte[1024];
            while ((read = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, read);
            }
            buffer.flush();
            byte[] byteArray = buffer.toByteArray();

            String text = new String(byteArray, StandardCharsets.UTF_8);
            assertEquals(originalString, text);
        }
    }
}
