package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_processing_page)
public class ProcessingPage extends AppCompatActivity
{

    @ViewById
    EditText textView35;

    @ViewById
    EditText textView39;

    @ViewById
    EditText textView40;

    @ViewById
    RecyclerView processing_page_orderSummary;

    @ViewById
    Button processing_page_received;

}