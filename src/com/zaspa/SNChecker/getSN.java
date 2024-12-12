package com.zaspa.SNChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class getSN {
    private static String serialNumber;

    public static void main(String[] args) {
        getSerialNumberFromOS();
    }

    public static void getSerialNumberFromOS() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("powershell", "Get-WmiObject Win32_BIOS | Select-Object -ExpandProperty SerialNumber");
            } else {
                processBuilder = new ProcessBuilder("sh", "-c", "sudo dmidecode -s system-serial-number");
            }
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    serialNumber = line.trim();
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSerialNumber() {
        return serialNumber;
    }
}