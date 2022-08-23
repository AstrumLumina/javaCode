package springcloud.mapper;

import com.xuanxie.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    public int addDept(Dept dept);
    public Dept deptById(@Param("deptid")int deptId);
    public List<Dept> getAllDept();
    public int updateDept(Dept dept);
    public int delDeptById(@Param("deptid") int deptId);
}
