package com.trubitpro.uploadapkplugin.help;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProcessUtils {


    private static final Integer WAIT_TIME = 60;

    /**
     * 执行脚本命令
     * @param commands
     * @throws
     */
    public static Integer exec(List<String> commands) throws Exception{

        String[] arrCommands = list2Array(commands);
        ProcessBuilder processBuilder =  new ProcessBuilder(arrCommands);
        processBuilder.redirectErrorStream(true);
        Process process = null;
        try {
            processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE); // 将输出重定向到空的OutputStream
              process = processBuilder.start();
            // 读取进程的输出流（可选）
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                // 处理输出（可选）
                System.out.println(line);
            }
            reader.close();
            process.waitFor(WAIT_TIME, TimeUnit.SECONDS);
            return process.exitValue();
        } finally {
            if(process != null){
                process.destroy();
            }
        }
    }

    public static String exeCmd(List<String> commands) throws Exception{

        String[] arrCommands = list2Array(commands);
        ProcessBuilder processBuilder =  new ProcessBuilder(arrCommands);
        processBuilder.redirectErrorStream(true);
        Process process = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE); // 将输出重定向到空的OutputStream
            process = processBuilder.start();
            // 读取进程的输出流（可选）
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                // 处理输出（可选）
                stringBuilder.append(" * ").append(line).append("\n ");
            }
            reader.close();
            process.waitFor(WAIT_TIME, TimeUnit.SECONDS);
            return stringBuilder.toString();
        } finally {
            if(process != null){
                process.destroy();
            }
        }
    }
    /**
     * List转String
     * @param commands
     * @return
     */
    private static String[] list2Array(List<String> commands){
        String[] commends = new String[commands.size()];
        commands.toArray(commends);
        return commends;
    }
}
