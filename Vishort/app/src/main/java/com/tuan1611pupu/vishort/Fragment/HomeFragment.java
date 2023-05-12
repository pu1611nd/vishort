package com.tuan1611pupu.vishort.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tuan1611pupu.vishort.Adapter.ReelsAdapter;
import com.tuan1611pupu.vishort.Model.Reels;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ItemReelsBinding;

import java.util.ArrayList;

public class HomeFragment  extends Fragment {


    int like;

    BottomSheetDialogFragment bottomSheetDialogFragment;
    Animation animation;
    private ArrayList<Reels> list;
    SimpleExoPlayer player;
    ItemReelsBinding playerBinding;
    int lastPosition = 0;
    Animation rotateanimation;
    private RecyclerView rvReels;
    private ReelsAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvReels = view.findViewById(R.id.rvReels);
        list = new ArrayList<>();
        adapter = new ReelsAdapter(list,getContext());
        getData();
        return  view;
    }

    private void getData() {

    }

    @Override
    public void onResume() {
        if (player != null) {
            player.setPlayWhenReady(true);
        }
        super.onResume();
    }

    @Override
    public void onStop() {
        if (player != null) {
            player.setPlayWhenReady(false);
        }
        super.onStop();
    }

    @Override
    public void onPause() {
        if (player != null) {
            player.setPlayWhenReady(false);
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (player != null) {
            player.setPlayWhenReady(false);
            player.stop();
            player.release();
        }
        super.onDestroy();
    }
}
