package com.example.fpapp.Activities;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.fpapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxiaojie on 2018-04-01.
 */
public class MainPageTest {

    @Rule
    public ActivityTestRule<MainPage> mActivityTestRule = new ActivityTestRule<MainPage>(MainPage.class);

    private MainPage mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunchOfMainLock(){

        View view = mActivity.findViewById(R.id.name1);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        mActivity = null;

    }

}