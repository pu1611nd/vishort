package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.tuan1611pupu.vishort.DataBinderMapperImpl());
  }
}
