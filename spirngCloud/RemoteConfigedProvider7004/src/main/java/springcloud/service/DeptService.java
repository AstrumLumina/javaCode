package springcloud.service;

import com.xuanxie.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept deptById(int deptId);
    public List<Dept> getAllDept();
    public boolean updateDept(Dept dept);
    public boolean delDeptById(int deptId);
}
