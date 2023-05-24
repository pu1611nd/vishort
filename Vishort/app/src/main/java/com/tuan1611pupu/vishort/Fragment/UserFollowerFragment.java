package com.tuan1611pupu.vishort.Fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tuan1611pupu.vishort.Adapter.FollowerUserAdapter;
import com.tuan1611pupu.vishort.Model.FollowUser;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.FragmentUserFollowerBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class UserFollowerFragment extends Fragment {
    FragmentUserFollowerBinding binding;
    FollowerUserAdapter followerUserAdapter;
    List<FollowUser> followUserList = new ArrayList<>();
    RecyclerView rcvFollowers;
    String api ="https://jsonplaceholder.typicode.com/users";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_follower, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        followerUserAdapter = new FollowerUserAdapter(this.getActivity(), followUserList);
        rcvFollowers = this.getActivity().findViewById(R.id.rvFollowers);
        binding.rvFollowers.setAdapter(followerUserAdapter);
        getFollowUserData();
        binding.rvFollowers.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
    }

    public void getFollowUserData(){
        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api, response -> {
            try{
                JSONArray array = new JSONArray(response);
                for(int i =0; i< array.length(); i++){
                    JSONObject object = array.getJSONObject(i);
                    FollowUser followUser = new FollowUser(object.getString("name"), object.getString("email"), " ", false);
                    followUserList.add(followUser);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, error -> Log.e("Error", error.toString()));
        queue.add(stringRequest);
    }
}