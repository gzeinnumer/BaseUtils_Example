package com.gzeinnumer.baseutils_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.gzeinnumer.bu.utils.CalculateDate;
import com.gzeinnumer.bu.utils.MBUtilsDate;
import com.gzeinnumer.bu.utils.MBUtilsString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "asdasdaadfasfasdc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
    }

    private void example1() {
        String value ="30-08-2020";

        String oldFormat = "dd-MM-yyyy";
        String newFormat = "yyyy-MM-dd";

        String reformatOneString = MBUtilsDate.reformatDate(
                value,
                oldFormat,
                newFormat,
                Locale.getDefault()
        );
        Log.d(TAG, "onCreate: before "+value+" after "+reformatOneString); //2020-08-30

    }

    private void example2() {
        String currentTime = MBUtilsDate.getCurrentTime("yyyy-MM-dd", Locale.getDefault());
        Log.d(TAG, "onCreate: "+currentTime); //2020-10-14
    }

    private void example3() {
        String toCheck = "07/10/2020";
        String startDate ="04/10/2020";
        String endDate = "08/10/2020";

        boolean isInRange = MBUtilsDate.checkBetween(toCheck, startDate,endDate);

        Log.d(TAG, "onCreate: "+isInRange); //true
    }

    private void example4() {
        try {
            String formatDate = "dd/MM/yyyy";
            SimpleDateFormat df = new SimpleDateFormat(formatDate);

            Date toCheck   = df.parse("07/10/2020");
            Date startDate = df.parse("04/10/2020");
            Date endDate   = df.parse("08/10/2020");

            boolean isInRange = MBUtilsDate.checkBetween(toCheck, startDate,endDate);

            Log.d(TAG, "onCreate: "+isInRange); //true
        } catch (ParseException e) {

        }
    }

    private void example5() {
        String time = "2014-01-11 10:10";
        String pattern = "yyyy-MM-dd HH:mm";

        CalculateDate calculateDate = new CalculateDate(time, pattern).addYear(2).addMonth(2);
        calculateDate.addWeek(1);
        calculateDate.addDay(2);
        calculateDate.addHour(2);
        calculateDate.addMinutes(2);

        String result = calculateDate.getResult();
        Log.d(TAG, "onCreate: "+result); //2016-03-20 12:12
    }

    private void example6() {
        String str = "!!??!@Hello Zein";

//Remove Last Char
        String result_1 = MBUtilsString.removeLastChar(str);
        Log.d(TAG, "onCreate_1: "+ result_1); //   !!??!@Hello Zei

//Remove Last Char Custom Length
        String result_2 = MBUtilsString.removeLastCharCustomLength(str,3);
        Log.d(TAG, "onCreate_2: "+ result_2); //   !!??!@Hello Z

//Remove All Simbol
        String result_3 = MBUtilsString.removeAllSimbol(str,"");
        Log.d(TAG, "onCreate_3: "+ result_3); //   HelloZein

//Remove Spesific Simbol
        String result_4 = MBUtilsString.removeSpesificSimbol(str,"","!","?","@");
        Log.d(TAG, "onCreate_4: "+ result_4); //   Hello Zein

//Remove First Char
        String result_5 = MBUtilsString.removeFirstChar(str);
        Log.d(TAG, "onCreate_5: "+ result_5); //   !??!@Hello Zein

//Remove First Char Custom Length
        String result_6 = MBUtilsString.removeFirstCharCustomLength(str,3);
        Log.d(TAG, "onCreate_6: "+ result_6); //   ?!@Hello Zein

//Get Name From Url
        String url = "https://asset-a.grid.id/crop/0x0:0x0/360x240/photo/2020/04/09/663219154.png";
        String result_7 = MBUtilsString.getNameFromUrl(url);
        Log.d(TAG, "onCreate_7: "+ result_7); //   663219154.png

//Remove Extension
        String result_8 = MBUtilsString.removeExtension(result_7);
        Log.d(TAG, "onCreate_8: "+ result_8); //   663219154
    }
}