package com.example.thethrillathand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JSY on 2016-02-04.
 */
public class myGroup {
        public ArrayList<String> child;
        public String groupName;
        myGroup(String name){
            groupName = name;
            child = new ArrayList<String>();
}
    }



