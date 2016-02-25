package com.artsam.accelerometer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artsam.accelerometer.MainActivity;
import com.artsam.accelerometer.R;
import com.artsam.accelerometer.adapter.DataRecAdapter;
import com.artsam.accelerometer.entity.Sample;
import com.artsam.accelerometer.view.MyPlotView;

import java.util.ArrayList;
import java.util.List;

public class DataFragment extends Fragment {

    private List<Sample> mSamples = new ArrayList<>();

    private RecyclerView mRecView;
    private MyPlotView mPlotView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MainActivity.MAIN_TAG, "DataFragment: onCreateView - "
                + getArguments().getString(""));

        View data = inflater.inflate(R.layout.frag_data, container, false);

        mRecView = (RecyclerView) data.findViewById(R.id.rv_samples);
        mRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecView.setAdapter(new DataRecAdapter(mSamples));

        mPlotView = (MyPlotView) data.findViewById(R.id.my_plot_View);
        mPlotView.setSamples(mSamples);

//        if(MainActivity.sSamplesRef != null){
//            MainActivity.sChildEventListener = MainActivity.sSamplesRef
//                    .addChildEventListener(new MyChildEventListener(mRecView, mPlotView));
//        } else {
//            data.findViewById(R.id.tv_instead_rv).setVisibility(View.VISIBLE);
//            data.findViewById(R.id.rv_samples).setVisibility(View.GONE);
//        }

        return data;
    }
}
