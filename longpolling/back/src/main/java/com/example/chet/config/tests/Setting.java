package com.example.chet.config.tests;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Setting {

    private String unCorLog;
    private String unCorPass;
    private String url;
    private String corPass;
    private String corLog;
    private String file = "filename.txt";
    private ObjectMapper mapper;

    public void setData() throws IOException {
        mapper=new ObjectMapper();
        DataJ dataJ=new DataJ();
        dataJ.setCorLog("olejiksin");
        dataJ.setCorPass("QaZWsXEdC99");
        dataJ.setUnCorLog(getAlphaNumericString(10));
        dataJ.setUnCorPass(getAlphaNumericString(10));
        dataJ.setUrl("https://hub.docker.com");
        mapper.writeValue(new File("filename.txt"),dataJ);
        File file = new File("filename.txt");
        FileReader fileReader = new FileReader(file);
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            line = bufferedReader.readLine();
        }
        DataJ dataJ1=mapper.readValue(line,DataJ.class);
        this.corLog=dataJ1.getCorLog();
        this.url=dataJ1.getUrl();
        this.corPass=dataJ1.getCorPass();
        this.unCorLog=dataJ1.getUnCorLog();
        this.unCorPass=dataJ1.getUnCorPass();
    }
    private String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"
                +"~!@#$%^&*()_+<,>.?/]}{[";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

}
