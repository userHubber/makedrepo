package kng.helpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import kng.Config;
import java.util.Random;
import java.util.ArrayList;

public class AdditionalData {

    public final Date DATE = new Date();
    private SimpleDateFormat sdf;
//================================================================================

    public int getCurrentTime() {
        sdf = new SimpleDateFormat("kk");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, 0);
        return Integer.parseInt(sdf.format(c.getTime()));
    }

    public String getPresetStringDate(int dayOffset) {
        sdf = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, dayOffset);
        return sdf.format(c.getTime());
    }

    public int getRandomNumeral(int end) {
        Random random = new Random();
        return random.nextInt(end);
    }

    public String getGeneratedMail() {
        String mail = "_t-t_email@yopmail.com";
        StringBuffer time_ = new StringBuffer(Long.toString(DATE.getTime()));
        StringBuffer _mail = new StringBuffer(time_.append(mail));
        return _mail.toString();
    }

    public String getGeneratedPhone() {
        StringBuffer time_ = new StringBuffer(Long.toString(DATE.getTime()));
        String phone = time_.delete(time_.length() - 1, time_.length()).substring(2).toString();
        return phone;
    }

    public String getSavedPhone(String phone) {
        StringBuffer phone_ = new StringBuffer(phone);
        String savedPhone = phone_.insert(0, '+')
                .insert(1, '7')
                .insert(2, " ")
                .insert(3, '(')
                .insert(7, ')')
                .insert(8, " ")
                .insert(12, '-')
                .insert(15, '-').toString();
        return savedPhone;
    }


    public ArrayList<String> getFileLinesToArrayList() {

        ArrayList<String> line = new ArrayList();
        try {
            FileInputStream fstream = new FileInputStream(Config.NO_COUPONS_BRANDS_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                line.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
