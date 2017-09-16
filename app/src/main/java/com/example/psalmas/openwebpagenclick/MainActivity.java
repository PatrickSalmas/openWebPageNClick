package com.example.psalmas.openwebpagenclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.lang.*;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebClient webClient = new WebClient();
        try {
            HtmlPage htmlPage = webClient.getPage("http://www.google.com");
            HtmlInput searchBox = htmlPage.getElementByName("q");
            searchBox.setValueAttribute("htmlunit");

            HtmlSubmitInput googleSearchSubmitButton = htmlPage.getElementByName("btnG");
            htmlPage = googleSearchSubmitButton.click();

            HtmlDivision resultStatsDiv = htmlPage.getFirstByXPath("//div[@id='resultStats']");

            Log.i("results", "results are " + resultStatsDiv.toString());
            webClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
