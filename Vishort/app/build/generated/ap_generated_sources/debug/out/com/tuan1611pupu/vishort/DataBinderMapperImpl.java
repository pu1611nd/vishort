package com.tuan1611pupu.vishort;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tuan1611pupu.vishort.databinding.ActivityEditBindingImpl;
import com.tuan1611pupu.vishort.databinding.FragmentMainProfileBindingImpl;
import com.tuan1611pupu.vishort.databinding.FragmentUserFollowerBindingImpl;
import com.tuan1611pupu.vishort.databinding.ItemFollowingListBindingImpl;
import com.tuan1611pupu.vishort.databinding.ItemPostVideoBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYEDIT = 1;

  private static final int LAYOUT_FRAGMENTMAINPROFILE = 2;

  private static final int LAYOUT_FRAGMENTUSERFOLLOWER = 3;

  private static final int LAYOUT_ITEMFOLLOWINGLIST = 4;

  private static final int LAYOUT_ITEMPOSTVIDEO = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tuan1611pupu.vishort.R.layout.activity_edit, LAYOUT_ACTIVITYEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tuan1611pupu.vishort.R.layout.fragment_main_profile, LAYOUT_FRAGMENTMAINPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tuan1611pupu.vishort.R.layout.fragment_user_follower, LAYOUT_FRAGMENTUSERFOLLOWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tuan1611pupu.vishort.R.layout.item_following_list, LAYOUT_ITEMFOLLOWINGLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tuan1611pupu.vishort.R.layout.item_post_video, LAYOUT_ITEMPOSTVIDEO);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYEDIT: {
          if ("layout/activity_edit_0".equals(tag)) {
            return new ActivityEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAINPROFILE: {
          if ("layout/fragment_main_profile_0".equals(tag)) {
            return new FragmentMainProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTUSERFOLLOWER: {
          if ("layout/fragment_user_follower_0".equals(tag)) {
            return new FragmentUserFollowerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_user_follower is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFOLLOWINGLIST: {
          if ("layout/item_following_list_0".equals(tag)) {
            return new ItemFollowingListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_following_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPOSTVIDEO: {
          if ("layout/item_post_video_0".equals(tag)) {
            return new ItemPostVideoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_post_video is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_edit_0", com.tuan1611pupu.vishort.R.layout.activity_edit);
      sKeys.put("layout/fragment_main_profile_0", com.tuan1611pupu.vishort.R.layout.fragment_main_profile);
      sKeys.put("layout/fragment_user_follower_0", com.tuan1611pupu.vishort.R.layout.fragment_user_follower);
      sKeys.put("layout/item_following_list_0", com.tuan1611pupu.vishort.R.layout.item_following_list);
      sKeys.put("layout/item_post_video_0", com.tuan1611pupu.vishort.R.layout.item_post_video);
    }
  }
}
