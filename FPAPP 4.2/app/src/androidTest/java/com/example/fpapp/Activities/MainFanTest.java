package com.example.fpapp.Activities;

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
public class MainFanTest {
    @Rule
    public ActivityTestRule<MainFan> mActivityTestRule = new ActivityTestRule<MainFan>(MainFan.class);

    private MainFan mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunchOfMainLock(){

        View view = mActivity.findViewById(R.id.textGrid);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        mActivity = null;

    }

}