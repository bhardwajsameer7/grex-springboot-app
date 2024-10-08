package com.grex.progress.persistence;

import com.grex.progress.model.Progress;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProgressRepository {

    @Select("SELECT * FROM GREX_PROGRESS WHERE user_stage_name = #{user_stage_name}")
    @Results({
            @Result(property = "stageName", column = "user_stage_name"),
    })
    public Progress findGroupsProgressByStageName(@Param("user_stage_name") String user_stage_name);

    @Select("SELECT ${dynamicColumn} FROM GREX_PROGRESS WHERE user_stage_name = #{user_stage_name}")
    public int findSpecificGroupProgressByStageName(@Param("user_stage_name") String user_stage_name, @Param("dynamicColumn") String dynamicColumn);

    @Insert("INSERT INTO GREX_PROGRESS VALUES( #{user_stage_name},0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)")
    int addSignUpProgress(@Param("user_stage_name") String user_stage_name);

 /*   @Select(QueryConstants.GET_SPECIFIC_GROUP_PROGRESS_BY_USER)
    @Results({
            @Result(property = "groupId", column = "group_id"),
            @Result(property = "groupName", column = "group_name"),
            @Result(property = "groupProgress", column = "group_progress"),
            @Result(property = "groupWords",column = "group_words",typeHandler = JsonTypeHandler.class)
    })
    public List<GroupProgress> findSpecificGroupProgressByUserId(@Param("user_name") String user_id, @Param("group_id") String group_id);

    @Update(QueryConstants.UPDATE_GROUP_PROGRESS_BY_USER)
    public int updateGroupStatus(@Param("user_name") String user_id, @Param("group_id") String group_id);*/

}
